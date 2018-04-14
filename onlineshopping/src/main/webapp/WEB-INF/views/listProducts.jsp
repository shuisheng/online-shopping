<%--
  Created by IntelliJ IDEA.
  User: liaoshuisheng
  Date: 2018/3/28
  Time: 02:16
  To change this template use File | Settings | File Templates.
--%>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <%@include file="./shared/sidebar.jsp"%>
        </div>

        <div class="col-md-9">
            <div class="row">
                <div class="col-lg-12">
                    <c:if test="${userClickAllProducts == true}">
                        <script>
                            window.categoryId = '';
                        </script>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                            <li class="active breadcrumb-item">All Products</li>
                        </ol>
                    </c:if>

                    <c:if test="${userClickCategoryProducts == true}">
                        <script>
                            window.categoryId = '${category.id}';
                        </script>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>

                            <li class="active breadcrumb-item">Category</li>

                            <li class="active breadcrumb-item">${category.name}</li>
                        </ol>
                    </c:if>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <table id="productListTable" class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Name</th>
                                <th>Brand</th>
                                <th>Price</th>
                                <th>Qty. Available</th>
                                <th></th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>