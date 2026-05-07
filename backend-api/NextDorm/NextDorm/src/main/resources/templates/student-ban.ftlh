<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/profile.css">
</head>
<body>
    
<!-- NAVBAR -->

    <nav class="navbar navbar-expand-lg ra-navbar">

        <div class="container-fluid">

            <!-- HEADER LOGO -->

            <a class="navbar-brand" href="/students">
                <img src="/images/nextdorm-logo-alt3.png" alt="Logo" width="155" height="55"
                    class="d-inline-block align-text-top">
            </a>

            <!-- COLLAPSE AT SIZE -->

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <!-- SEARCH BAR -->

                <form class="d-flex navbar-search" role="search">

                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                    <button class="btn btn-outline-custom" type="submit">Search</button>

                </form>

                    <a class="navbar-icon" id="profile-icon" href="profile.html">
                        <img src="/images/nextdorm-icon-profile.png" alt="Logo" width="60" height="60"
                            class="d-inline-block align-text-top">
                    </a>

            </div>

        </div>

    </nav>

    <!--Profile section-->
     <div class="card-wrapper">
        <div class="card">
            <p>You currently cannot post for the following reason: ${ban.description} <br>
            You may post again in ${ban.banLength} days.
            </p>
            <a href="/students" class="btn btn-primary">Back to post feed</a>
        </div>
    </div>




    
</body>
</html>