<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
    <div class="card h-100">
        <div class="card-body">
            <div class="row gutters">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <h6 class="mb-2 text-primary">Personal Details</h6>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12" style='display: none'>
                    <div class="form-group">
                        <label for="fullName">Account ID</label>
                        <input type="text" class="form-control" 
                               name='accountID' value='${account.accountID}'>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12" style='display: none'>
                    <div class="form-group">
                        <label for="fullName">Customer ID</label>
                        <input type="text" class="form-control" 
                               name='customerID' value='${customer.customerID}'
                               readonly>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="form-group">
                        <label for="fullName">Full Name</label>
                        <input type="text" class="form-control" id="fullName" placeholder="Enter full name"
                               name='fullName' value='${account.fullName}'
                               readonly>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="form-group">
                        <label for="eMail">Username</label>
                        <input type="text" class="form-control" id="eMail" placeholder="Enter username"
                               name='userName' value='${account.userName}'
                               readonly>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="number" class="form-control" id="phone" placeholder="Enter phone number"
                               name='phone' value='${phone}'
                               readonly>
                    </div>
                </div>   
            </div>
            <div class="row gutters">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <h6 class="mt-3 mb-2 text-primary">Address</h6>
                </div>
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Enter address"
                               name='address' value='${customer.address}'
                               readonly>
                    </div>
                </div>    
            </div>
            <div class="row gutters">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <h6 class="mt-3 mb-2 text-primary">Password</h6>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="form-group">
                        <label for="ciTy">Password</label>
                        <input type="text" class="form-control" id="ciTy" placeholder="Enter pasword"
                               name='password' value='${account.password}'
                               readonly>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12" 
                     >
                    <div class="form-group">
                        <label for="sTate" >Repeat</label>
                        <input type="text" class="form-control" id="sTate" placeholder="Enter re-password"
                               name='re-password' value='${customer.password}'
                               readonly>
                    </div>
                </div>
            </div>
            <div class="row gutters">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div style="height: 50px; width: 100%; display: flex; justify-content: right;">
                        <a class="button" 
                           href="delete?option=account&aid=${account.accountID}&cid=${customer.customerID}" 
                           onclick="return confirmDelete()">
                            Delete account
                        </a>
                        <a class="button" 
                           href='view?option=profile'>
                            Edit information
                        </a>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
