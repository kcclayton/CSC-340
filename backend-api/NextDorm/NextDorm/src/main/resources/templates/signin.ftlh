<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Landing Page</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/style.css">
</head>
<body>

        <!--Nav Bar-->
        <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
            <img src="/Images/nextdorm-logo.png" alt="Logo" width="60" height="54" class="d-inline-block align-text-top">
            </a>

            <a href="signup.ftlh" class="btn custom-button">Create an account</a>
        </div>
        </nav>
        
        <!--Text above card-->
        <div class="neighbor-text">
            <h1>Hey, <br>
            Neighbor!</h1>
        </div>

    <!--Main card-->
    <div class="card-background">
        <div class = "card-wrapper">
        <div class="card">
            <div class="container">
                <div class="mb-3">
                    <div class="mb-3">
                        <form action="/students/signin" method="post">

                            <label class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email">

                            <label class="form-label">Password</label>
                            <input type="password" class="form-control" id="userPassword" name="password">

                            <button type="submit" class="btn" id="submit-btn">Submit</button>

                        </form>

                    <p>OR</p>
                        <div class="d-flex justify-content-center">
                            <a href="../Provider/landing.html" button type="button" class="btn" id="ra-btn">Sign in as an RA</button></a>
                        </div>

                </div>
            </div>
        </div>
    </div>



</body>
</html>