<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Hello</h1>
            <div class="account-wall">
                <img class="profile-img" src="/static/photo.jpg"
                    alt="Profile Image">
                <form class="form-signin" method='post' action='/login'>
	                <input type="text" name='email' class="form-control" 
	                	placeholder="Email" required autofocus>
	                <input type="password" name='password' class="form-control" 
	                	placeholder="Password" required>
	                <button class="btn btn-lg btn-primary btn-block" type="submit">
	                    Sign in</button>
                
                </form>
            </div>
        </div>
    </div>
</div>