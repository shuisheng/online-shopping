<%--
  Created by IntelliJ IDEA.
  User: liaoshuisheng
  Date: 2018/4/15
  Time: 00:46
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

    <c:if test="${not empty message}">

        <div class="col-xs-12 ">
            <div class="alert alert-success alert-dismissible">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                    ${message}
            </div>
        </div>
    </c:if>

    <div class="row">

        <div class="col-md-offset-2 col-md-8">

            <div class="panel panel-primary">

                <div class="panel-heading">

                    <h4>Product Management</h4>

                </div>

                <div class="panel-body">
                    <sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/product"
                             method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="control-label col-md-4">Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="name" class="form-control" placeholder="Product Name" />
                                <sf:errors path="name" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Brand</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="brand" class="form-control"
                                          placeholder="Brand Name" />
                                <sf:errors path="brand" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Description</label>
                            <div class="col-md-8">
                                <sf:textarea path="description" class="form-control"
                                             placeholder="Enter your description here!" />
                                <sf:errors path="description" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Unit Price</label>
                            <div class="col-md-8">
                                <sf:input type="number" path="unitPrice" class="form-control"
                                          placeholder="Enter Unit Price" />
                                <sf:errors path="unitPrice" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Quantity</label>
                            <div class="col-md-8">
                                <sf:input type="number" path="quantity" class="form-control"
                                          placeholder="Enter Quantity" />
                                <sf:errors path="quantity" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <!-- File element for image upload -->
                        <div class="form-group">
                            <label class="control-label col-md-4">Select an image:</label>
                            <div class="col-md-8">
                                <sf:input type="file" path="file" class="form-control" />
                                <sf:errors path="file" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Category</label>
                            <div class="col-md-8">
                                <sf:select path="categoryId" items="${categories}" itemLabel="name" itemValue="id"
                                           class="form-control"/>
                                <c:if test="${product.id == 0}">
                                    <div class="text-right">
                                        <br/>
                                        <button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-xs">
                                            Add Category</button>
                                    </div>

                                </c:if>
                            </div>

                        </div>



                        <div class="form-group">

                            <div class="col-md-offset-4 col-md-4">

                                <input type="submit" name="submit" value="Submit" class="btn btn-primary"/>

                                <!-- Hidden fields for product -->
                                <sf:hidden path="id"/>
                                <sf:hidden path="code"/>
                                <sf:hidden path="supplierId"/>
                                <sf:hidden path="active"/>
                                <sf:hidden path="purchases"/>
                                <sf:hidden path="views"/>
                            </div>
                        </div>

                    </sf:form>

                </div>

            </div>

        </div>

    </div>

    <div class="row">

        <div class="col-xl-12">
            <h3>Available Products</h3>
            <hr/>
        </div>

        <div class='col-xl-12'>
            <div style="overflow: auto" >
                <table id="adminProductsTable" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>&#160;</th>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Qty. Avail</th>
                            <th>Unit Price</th>
                            <th>Activate</th>
                            <th>Edit</th>
                        </tr>
                    </thead>

                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>&#160;</th>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Qty. Avail</th>
                            <th>Unit Price</th>
                            <th>Activate</th>
                            <th>Edit</th>
                        </tr>
                    </tfoot>


                </table>


            </div>
            <!-- Products table for Admin -->

        </div>


    </div>

    <!-- Modal -->
    <div class="modal fade" id="myCategoryModal" tabindex="-1" role="dialog" aria-labelledby="myCategoryModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="myCategoryModalLabel">Add New Category</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="post" class="form-horizontal">
                        <div class="form-group">
                            <label for="category_name" class="control-label col-md-4">Category Name</label>
                            <div class="col-md-8">
                                <sf:input path="name" type="text" id="category_name" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="category_description" class="control-label col-md-4">Category Description</label>
                            <div class="col-md-8">
                                <sf:textarea cols="" rows="5" path="description" id="category_description" type="text" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" value="Add Category" class="btn btn-primary"/>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>

        </div>
    </div>

</div>