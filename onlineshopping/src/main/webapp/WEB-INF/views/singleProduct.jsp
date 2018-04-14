<%--
  Created by IntelliJ IDEA.
  User: liaoshuisheng
  Date: 2018/4/13
  Time: 01:26
  To change this template use File | Settings | File Templates.
--%>

<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                    <li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Products</a></li>
                    <li class="active breadcrumb-item">${product.name}</li>
                </ol>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-6">
            <div class="img-thumbnail">
                <img src="${images}/${product.code}.jpg" class="img img-responsive"/>
            </div>
        </div>
        <div class="col-lg-6">
            <h3>${product.name}</h3>
            <hr/>

            <p>${product.description}</p>
            <hr/>

            <h4>Price: <strong>${product.unitPrice}</strong></h4>
            <hr/>

            <c:choose>
                <c:when test="${product.quantity < 1}">
                    <h6>Qty. Available: <span style="color:red">Out of Stock!</span></h6>
                </c:when>
                <c:otherwise>
                    <h6>Qty. Available: ${product.quantity}</h6>
                </c:otherwise>
            </c:choose>


            <c:choose>
                <c:when test="${product.quantity < 1}">
                    <a href="javascript void(0)" class="btn btn-success disabled"><strike>
                        <span class="glyphicon glyphicon-shopping-cart">Add to Cart</span></strike> </a>
                </c:when>

                <c:otherwise>
                    <a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
                        <span class="glyphicon glyphicon-shopping-cart">Add to Cart</span> </a>
                </c:otherwise>
            </c:choose>

            <a href="${contextRoot}/show/all/products" class="btn btn-success">Back</a>
        </div>
    </div>
</div>
