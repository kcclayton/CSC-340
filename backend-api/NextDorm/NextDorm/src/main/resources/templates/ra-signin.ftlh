<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RA Sign In</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    <link rel="icon" href="/Images/nextdorm-logo-alt2.png" type="image/png">
    <link rel="stylesheet" href="/style.css">
</head>
<body>

    <!-- Nav Bar -->
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="/Images/nextdorm-logo.png" alt="Logo" width="60" height="54" class="d-inline-block align-text-top">
            </a>
            <a href="/ras/signup" class="btn custom-button">Create an account</a>
        </div>
    </nav>

    <!-- Text above card -->
    <div class="neighbor-text">
        <h1>Hey, <br>Neighbor!</h1>
    </div>

    <!-- Main card -->
    <div class="card-background">
        <div class="card-wrapper">
            <div class="card">
                <div class="container">
                    <div class="mb-3">
                        <div class="mb-3">

                            <#if error??>
                                <div class="alert alert-danger">${error}</div>
                            </#if>

                            <form action="/ras/signin" method="post">

                                <label class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email">

                                <label class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password">

                                <button type="submit" class="btn" id="submit-btn">Submit</button>

                            </form>

                            <p>OR</p>
                            <div class="d-flex justify-content-center">
                                <a href="/students/signin" type="button" class="btn" id="ra-btn">Sign in as a Student</a>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
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
