<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RA Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    <link rel="icon" href="/Images/nextdorm-logo-alt2.png" type="image/png">
    <link rel="stylesheet" href="/sign-up.css">
</head>
<body>

    <!-- Nav Bar -->
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="/Images/nextdorm-logo.png" alt="Logo" width="60" height="54" class="d-inline-block align-text-top">
            </a>
            <a href="/ras/signin" class="btn custom-button">Log in</a>
        </div>
    </nav>

    <div class="card-wrapper">
        <div class="card">
            <h1>Register an RA Account</h1>

            <form action="/ras/signup" method="post" class="row g-3">

                <div class="col-md-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>

                <div class="w-100"></div>

                <div class="col-md-4">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" name="username">
                </div>
                <div class="col-md-4">
                    <label for="userPassword" class="form-label">Password</label>
                    <input type="password" class="form-control" id="userPassword" name="userPassword">
                </div>

                <div class="w-100"></div>

                <div class="col-md-4">
                    <label for="email" class="form-label">Email Address</label>
                    <input type="email" class="form-control" id="email" name="email">
                </div>
                <div class="col-md-4">
                    <label for="residenceDescription" class="form-label">Residence Description</label>
                    <input type="text" class="form-control" id="residenceDescription" name="residenceDescription">
                </div>

                <input type="hidden" name="role" value="RA">

                <div class="col-12 d-flex justify-content-center">
                    <button type="submit" class="custom-button" id="create-button">Create Account</button>
                </div>

            </form>
        </div>
    </div>


    <!-- Sign Out Confirmation Modal -->
    <div class="modal fade" id="signoutModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Sign Out</h5>
                </div>
                <div class="modal-body">
                    This will direct you back to the login page. Are you sure?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Go Back</button>
                    <a href="/ras/signout" class="btn btn-outline-custom">I'm Sure</a>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
