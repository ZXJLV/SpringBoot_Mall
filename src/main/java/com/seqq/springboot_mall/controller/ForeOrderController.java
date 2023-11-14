package com.seqq.springboot_mall.controller;

import com.alibaba.fastjson2.JSON;
import com.google.gson.Gson;
import com.seqq.springboot_mall.entity.*;
import com.seqq.springboot_mall.mapper.ProductorderitemMapper;
import com.seqq.springboot_mall.service.*;
import com.seqq.springboot_mall.util.AddressData;
import com.seqq.springboot_mall.util.ColorConsole;
import com.seqq.springboot_mall.util.OrderUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller("/foreOrderController")
public class ForeOrderController {

    @Autowired
    ProductorderService productorderService;

    @Autowired
    ProductorderitemService productorderitemService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductimageService productimageService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AddressService addressService;

    @RequestMapping("/order/{productorderUserId}")
    public String order(@PathVariable("productorderUserId") int productorderUserId, HttpServletRequest request) {
//        System.out.println("productorderUserId:"+productorderUserId);
//
//        List<Productorder> productorderList = productorderService.selectProductOrderByProductorderUserId(productorderUserId);
//        for (Productorder productorder : productorderList) {
//            Productorderitem productorderitem = productorderitemService.selectProductorderitemByProductorderitemOrderId(productorder.getProductorderId());
//            productorder.setProductorderitem(productorderitem);
//            Product product = productService.selectProductByProductorderitemProductId(productorderitem.getProductorderitemProductId());
//            productorderitem.setProduct(product);
//            List<Productimage> productimageList = productimageService.selectProductimageAll(productorderitem.getProductorderitemProductId());
//            productorderitem.setProductimageList(productimageList);
//
//            Review review = reviewService.selectReviewByReviewOrderItemId(productorderitem.getProductorderitemId());
//            productorderitem.setReview(review != null);
//
//            System.err.println("\u001B[36m productorderList:" + productorder + "\u001B[0m");
//        }
//        request.setAttribute("productOrderList", productorderList);
//
//        List<Productorderitem> productorderitemList = productorderitemService.selectProductorderitemsByProductorderitemUserId(productorderUserId);
//        request.setAttribute("productOrderItemList", productorderitemList);


//        List<Productorderitem> productOrderItemList = new ArrayList<>();
//        Productorderitem productorderitem;
//
//        List<Productorder> productOrderList = productorderService.selectProductOrderByProductorderUserId(productorderUserId);
//        for (Productorder productorder : productOrderList) {
//            System.err.println("\u001B[41m productOrderList:" + productorder + "\u001B[0m");
//            productorderitem = productorderitemService.selectProductorderitemByProductorderitemOrderId(productorder.getProductorderId());
//            for (Productorderitem productorderitem2 : productOrderItemList) {
//                System.err.println("\u001B[33m productOrderItemList:" + productorderitem2 + "\u001B[0m");
//                Review review = reviewService.selectReviewByReviewOrderItemId(productorderitem2.getProductorderitemId());
//                productorderitem.setIsReview(review != null);
//                Product product = productService.selectProductByProductorderitemProductId(productorderitem2.getProductorderitemProductId());
//                productorderitem.setProductOrderItemProduct(product);
//                List<Productimage> singleProductImageList = productimageService.selectProductimageAll(productorderitem2.getProductorderitemProductId());
//                product.setSingleProductImageList(singleProductImageList);
//            }
//            productOrderItemList.add(productorderitem);
//        }
//        request.setAttribute("productOrderList", productOrderList);
//        request.setAttribute("productOrderItemList", productOrderItemList);

        List<Productorder> productOrderList = productorderService.selectProductOrderByProductorderUserId(productorderUserId);
        for (Productorder productorder : productOrderList) {
            List<Productorderitem> productOrderItemList = productorderitemService.selectProductorderitemByProductorderitemOrderId(productorder.getProductorderId());
            for (Productorderitem productorderitem : productOrderItemList) {

                // 查询评论
                Review review = reviewService.selectReviewByReviewOrderItemId(productorderitem.getProductOrderItemId());
                productorderitem.setReview(review != null);

                // 根据订单详细表的商品id查询商品详细信息
                Product product = productService.selectProductByProductorderitemProductId(productorderitem.getProductOrderItemProductId());
                productorderitem.setProduct(product);

                // 根据商品id查询商品图片
                List<Productimage> productimageList = productimageService.selectProductimageAll(product.getProductId());
                productorderitem.setProductimageList(productimageList);

            }
            productorder.setProductOrderItemList(productOrderItemList);

            System.err.println("\u001B[36m productOrderList:" + productorder + "\u001B[0m");
            request.setAttribute("productOrderItemList", productOrderItemList);

        }

        request.setAttribute("productOrderList", productOrderList);

        return "/fore/orderListPage";
    }

    @GetMapping("/confirm/{productOrderCode}")
    public String confirm(@PathVariable("productOrderCode") String productOrderCode, HttpServletRequest request) {
        Productorder productorder = productorderService.selectProductorderByProductorderCode(productOrderCode);

        List<Productorderitem> productorderitemList = productorderitemService.selectProductorderitemByProductorderitemOrderId(productorder.getProductorderId());
        productorder.setProductOrderItemList(productorderitemList);
        for (Productorderitem productorderitem : productorderitemList) {
            List<Productimage> productimageList = productimageService.selectProductimageAll(productorderitem.getProductOrderItemProductId());
            productorderitem.setProductimageList(productimageList);
            Product product = productService.selectProductByProductorderitemProductId(productorderitem.getProductOrderItemProductId());
            productorderitem.setProduct(product);
            request.setAttribute("orderTotalPrice", productorderitem.getProductOrderItemPrice());
        }

        request.setAttribute("productOrder", productorder);
        return "/fore/orderConfirmPage";
    }

    @PostMapping("/success/{productOrderCode}")
    @ResponseBody
    public String success(@PathVariable String productOrderCode) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String productorderConfirmDate = currentDateTime.format(formatter);

        System.err.println("\u001B[41m productOrderCode:" + productOrderCode + "\u001B[0m");
        int i = productorderService.updateProductorderProductorderStatusByProductorderId(productOrderCode, productorderConfirmDate);
        String json = JSON.toJSONString(i);
        System.err.println("\u001B[41m json:" + json + "\u001B[0m");
        return json;
    }

    @GetMapping("/delivery/{productOrderCode}/{userId}")
    public String delivery(@PathVariable String productOrderCode, @PathVariable int userId) {
        System.err.println("\u001B[41m userId:" + userId + "\u001B[0m");
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String productorderDeliveryDate = currentDateTime.format(formatter);
        int i = productorderService.updateProductorderProductorderStatusAndProductorderDeliveryDateByProductorderId(productOrderCode, productorderDeliveryDate);
        return "redirect:/order/" + userId;
    }

    @GetMapping("/pay/{productOrderCode}")
    public String pay(@PathVariable String productOrderCode, HttpServletRequest request) {
        Productorder productorder = productorderService.selectProductorderByProductorderCode(productOrderCode);
        List<Productorderitem> productorderitemList = productorderitemService.selectProductorderitemByProductorderitemOrderId(productorder.getProductorderId());
        for (Productorderitem productorderitem : productorderitemList) {
            Product product = productService.selectProductByProductorderitemProductId(productorderitem.getProductOrderItemProductId());
            productorderitem.setProduct(product);
            Category category = categoryService.selectCategoryByProductCategoryId(product.getProductCategoryId());
            product.setCategory(category);

            request.setAttribute("orderTotalPrice", productorderitem.getProductOrderItemPrice());
        }
        productorder.setProductOrderItemList(productorderitemList);
        System.err.println("\u001B[33m productorder:" + productorder + "\u001B[0m");

        request.setAttribute("productOrder", productorder);
        return "/fore/productPayPage";
    }

    @PutMapping("/doPay/{productOrderCode}")
    @ResponseBody
    public String doPay(@PathVariable String productOrderCode) {

        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String productorderPayDate = currentDateTime.format(formatter);

        int i = productorderService.updateProductorderProductorderStatusAndProductorderPayDateByProductorderId(productOrderCode, productorderPayDate);
        String json = JSON.toJSONString(i);
        return json;
    }

    @GetMapping("/toSuccessPage")
    public String toSuccessPage() {

        return "/fore/orderSuccessPage";
    }

    @PutMapping("/close/{productOrderCode}")
    @ResponseBody
    public String close(@PathVariable String productOrderCode) {
        Productorder productorder = productorderService.selectProductorderByProductorderCode(productOrderCode);
        List<Productorderitem> productorderitemList = productorderitemService.selectProductorderitemByProductorderitemOrderId(productorder.getProductorderId());
        int i = productorderService.deleteProductorderByProductorderCode(productOrderCode);
        int i1 = 0;
        for (Productorderitem productorderitem : productorderitemList) {
            i1 = productorderitemService.deleteProductorderitemByProductorderitemOrderId(productorderitem.getProductOrderItemOrderId());
        }

        String json = JSON.toJSONString(i+i1);

        return json;
    }

    @GetMapping("/create/{productId}/{userId}")
    public String create(@PathVariable int productId, @PathVariable int userId, @RequestParam("product_number") int product_number, HttpServletRequest request) {
        System.err.println("\u001B[33m productId:" + productId + "\u001B[0m");
        System.err.println("\u001B[33m product_number:" + product_number + "\u001B[0m");
        List<Address> addressList = addressService.selectAddress();

        Productorder productorder = productorderService.selectProductorderByProductorderUserIdAndProductorderId(userId);
        Address districtAddress = addressService.selectAddressByAddressAreaId(productorder.getProductOrderAddress());
        Address cityAddress = addressService.selectAddressByAddressAreaId(districtAddress.getAddressRegionId());
        Address address = addressService.selectAddressByAddressAreaId(cityAddress.getAddressRegionId());

        List<Productorderitem> productorderitemList = new ArrayList<Productorderitem>();
        Productorderitem productorderitem1 = new Productorderitem();


        Product product = productService.selectProductByProductorderitemProductId(productId);
        Category category = categoryService.selectCategoryByProductCategoryId(product.getProductCategoryId());
        product.setCategory(category);
        List<Productimage> productimageList = productimageService.selectProductimageAll(productId);
        product.setSingleProductImageList(productimageList);
        System.err.println("\u001B[41m product:" + product + "\u001B[0m");
        productorderitem1.setProductOrderItemPrice(product.getProductSalePrice()*product_number);
        productorderitem1.setProductOrderItemNumber(product_number);
        productorderitem1.setProduct(product);
        productorderitemList.add(productorderitem1);
        for (Productorderitem productorderitem : productorderitemList) {
            System.err.println("\u001B[33m productorderitemList:" + productorderitem + "\u001B[0m");
        }

        request.setAttribute("order_receiver", productorder.getProductOrderReceiver());
        request.setAttribute("order_phone", productorder.getProductOrderMobile());
        request.setAttribute("detailsAddress", address.getAddressName() + cityAddress.getAddressName() + districtAddress.getAddressName());
        request.setAttribute("orderTotalPrice", product.getProductSalePrice()*product_number);
        request.setAttribute("orderItemList", productorderitemList);
        request.setAttribute("addressList", addressList);
        request.setAttribute("districtAddressId", districtAddress.getAddressAreaId());
        request.setAttribute("cityAddressId", cityAddress.getAddressAreaId());
        request.setAttribute("addressId", address.getAddressAreaId());
        request.setAttribute("productorder", productorder);


//        request.setAttribute("addressId", 410000);
        return "fore/productBuyPage";
    }

    @GetMapping("/orderAddress/{addressAreaId}")
    @ResponseBody
    public String orderAddress(@PathVariable int addressAreaId, HttpServletRequest request) {
        List<Address> cityList = addressService.selectAddressByAddressRegionId(addressAreaId);
        for (Address address : cityList) {
            System.err.println("\u001B[41ma cityList:" + address + "\u001B[0m");
        }
        Address firstAddress = cityList.get(0); // 获取第一个元素
        int firstAddressAreaId = Integer.parseInt(firstAddress.getAddressAreaId());
        // 现在 firstAddressAreaId 包含了第一组数据的 addressAreaId
        System.out.println("第一组数据的 addressAreaId: " + firstAddressAreaId);

        List<Address> districtList = addressService.selectAddressByAddressRegionId(firstAddressAreaId);
        for (Address address : districtList) {
            System.err.println("\u001B[41ma cityList:" + address + "\u001B[0m");
        }
        request.setAttribute("cityList", cityList);
        request.setAttribute("districtList", districtList);

        // 创建 AddressData 对象并设置数据
        AddressData addressData = new AddressData(cityList, districtList);
        String jsonResponse = new Gson().toJson(addressData);

        System.err.println("\u001B[33m addressData:" + jsonResponse + "\u001B[0m");
        return jsonResponse;
    }

    @PostMapping("/createOrder")
    @ResponseBody
    public String createOrder(int userId, int addressId, int cityAddressId, String districtAddressId, String productOrderDetailAddress, String productOrderPost, String productOrderReceiver, String productOrderMobile, String userMessage, int orderItem_product_id, int orderItem_number) {
        ColorConsole.printCyan("userId:"+userId);
        ColorConsole.printCyan("addressId:"+addressId);
        ColorConsole.printCyan("cityAddressId:"+cityAddressId);
        ColorConsole.printCyan("districtAddressId:"+districtAddressId);
        ColorConsole.printCyan("productOrderDetailAddress:"+productOrderDetailAddress);
        ColorConsole.printCyan("productOrderPost:"+productOrderPost);
        ColorConsole.printCyan("productOrderReceiver:"+productOrderReceiver);
        ColorConsole.printCyan("productOrderMobile:"+productOrderMobile);
        ColorConsole.printCyan("userMessage:"+userMessage);
        ColorConsole.printCyan("orderItem_product_id:"+orderItem_product_id);
        ColorConsole.printCyan("orderItem_number:"+orderItem_number);

        String productOrderCode = OrderUtil.generateProductOrderCode();
        ColorConsole.printBlue("productOrderCode:"+productOrderCode);

        Product product = productService.selectProductByProductorderitemProductId(orderItem_product_id);

        int i = productorderService.insertProductorder(new Productorder(
                -1, productOrderCode, districtAddressId, productOrderDetailAddress, productOrderPost, productOrderReceiver, productOrderMobile, "", "", "", 0, userId,null,-1, null, -1, -1,-1
                ));

        Productorder productorder = productorderService.selectProductorderByProductorderCode(productOrderCode);

        int i2 = productorderitemService.insertProductorderitem(new Productorderitem(
                -1, orderItem_number, product.getProductSalePrice()*orderItem_number,
                orderItem_product_id, productorder.getProductorderId(), userId, userMessage, null, null, false
        ));

        ColorConsole.printBlack("i"+i+"\ti1"+i2);
        String url = null;
        String json = null;
        if (i+i2>=2) {
            url = "/pay/"+productOrderCode;
            json = JSON.toJSONString(url);
        }
        ColorConsole.printBlue("json:"+json);
        return json;
    }

    @GetMapping("/toProductPayPage/{productOrderCode}")
    public String toProductPayPage(@PathVariable String productOrderCode, HttpServletRequest request) {
        ColorConsole.printPurple("toProductPayPage");
        ColorConsole.printGreen("productOrderCode:"+productOrderCode);


        return "/fore/productPayPage";
    }

}
