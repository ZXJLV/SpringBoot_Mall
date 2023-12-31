<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="include/header.jsp" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<head>
    <script src="${ctx}/res/js/jquery-color-2.1.2.js"></script>
    <script src="${ctx}/res/js/fore/fore_home.js"></script>
    <link href="${ctx}/res/css/fore/fore_home.css" rel="stylesheet"/>
    <title>Mall商城mall.com--理想生活上Mall商城</title>
</head>
<body>
<nav>
    <%@ include file="include/navigator.jsp" %>
    <div class="header">
        <img src="${ctx}/res/images/fore/WebsiteImage/HomeLogoB.png">
        <div class="mallSearch">
            <form action="${ctx}/product" method="get">
                <div class="mallSearch-input">
                    <input class="header_search_input" type="text" name="productName" placeholder="搜索 商品/品牌/店铺"
                           maxlength="50">
                    <input class="header_search_button" type="submit" value="搜索">
                </div>
            </form>
            <ul>
                <c:forEach items="${requestScope.categoryList}" var="category" varStatus="i">
                    <c:if test="${i.index<9}">
                        <li><a href="${ctx}/product?categoryId=${category.categoryId}"
                                <c:if test="${i.index % 2 != 0}"> style="color: #FF0036"</c:if>>${fn:substring(category.categoryName,0,fn:indexOf(category.categoryName,' /'))}</a>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="home_nav">
        <div class="home_nav_title">
            <img src="${ctx}/res/images/fore/WebsiteImage/header_nav_title.png">
            <span>商品分类</span>
        </div>
        <a href="http://vip.mall.com/" target="_blank">Mall会员</a>
        <a href="https://miao.mall.com/" target="_blank">Mall生鲜</a>
        <a href="https://3c.mall.com/" target="_blank">智能家居</a>
        <a href="http://yao.mall.com/" target="_blank">医药馆</a>
        <a href="http://yao.mall.com/" target="_blank">医药馆</a>
        <a href="http://wt.mall.com/" target="_blank">营业厅</a>
        <a href="https://pin.mall.com/" target="_blank">Mall拼团</a>
        <a href="https://suning.mall.com/" target="_blank">苏宁易购</a>
        <a href="https://alitrip.mall.com/" target="_blank">Mall旅行</a>
    </div>
</nav>
<div class="banner">
    <c:forEach var="product" items="${requestScope.specialProductList}" varStatus="i">
        <img src="${ctx}/res/images/fore/WebsiteImage/banner/${product.productId}.jpg"
             name="${product.productId}" id="banner${i.count}"
             <c:if test="${i.count == 1}">style="display: block;"</c:if> />
    </c:forEach>
</div>
<div class="banner_main">
    <ul class="banner_nav">
        <c:forEach items="${requestScope.categoryList}" var="category">
            <li data-toggle="${category.categoryId}" data-status="">
                <img src="${ctx}/res/images/fore/WebsiteImage/small/${category.categoryId}.png">
                <a href="${ctx}/product?categoryId=${category.categoryId}">${category.categoryName}</a>
                <div class="banner_div" name="${category.categoryName}"></div>
            </li>
        </c:forEach>
    </ul>
    <ul class="banner_slider">
        <li id="slider_1" style="background: rgba(255,255,255,0.4)"></li>
        <li id="slider_2"></li>
        <li id="slider_3"></li>
        <li id="slider_4"></li>
        <li id="slider_5"></li>
        <li id="slider_6"></li>
    </ul>
    <a href="#"></a>
</div>
<div class="banner_do">
    <div class="banner_goods">
        <c:forEach items="${requestScope.categoryList}" var="category">
            <c:if test="${fn:length(category.productList)>0}">
                <div class="banner_goods_type">
                    <div class="banner_goods_title">
                        <span></span>
                        <p>${category.categoryName}</p>
                    </div>
                    <a href="${ctx}/product?categoryId=${category.categoryId}"><img
                            class="banner_goods_show"
                            src=${ctx}"res/images/fore/WebsiteImage/show/${category.categoryId}.jpg"></a>
                    <div class="banner_goods_items">
                        <c:forEach items="${category.productList}" var="product" varStatus="i">
                            <c:if test="${i.index<8}">
                                <div class="banner_goods_item">
                                    <a href="product/${product.productId}" class="goods_link"></a>
                                    <img src="${ctx}/res/images/item/productSinglePicture/${product.singleProductImageList[0].productimageSrc}">
                                    <a href="product/${product.productId}"
                                       class="goods_name">${product.productName}</a>
                                    <span class="goods_price">￥${product.productSalePrice}</span>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <div class="endDiv"></div>
</div>
<%@ include file="include/footer_two.jsp" %>
<%@ include file="include/footer.jsp" %>
</body>