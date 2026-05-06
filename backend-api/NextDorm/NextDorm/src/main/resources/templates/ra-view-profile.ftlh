<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RA Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    <link rel="icon" href="/Images/nextdorm-logo-alt2.png" type="image/png">
    <link rel="stylesheet" href="/profile.css">
</head>
<body>

    <!-- NAVBAR -->
    <nav class="navbar navbar-expand-lg ra-navbar">
        <div class="container-fluid">
            <a class="navbar-brand" href="/ras/dashboard">
                <img src="/Images/nextdorm-logo-alt3.png" alt="Logo" width="155" height="55" class="d-inline-block align-text-top">
            </a>
            <div class="collapse navbar-collapse">
                <form class="d-flex navbar-search" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" />
                    <button class="btn btn-outline-custom" type="submit">Search</button>
                </form>
                <a class="navbar-icon" href="/ras/profile">
                    <img src="/Images/nextdorm-icon-profile.png" alt="Profile" width="60" height="60" class="d-inline-block align-text-top">
                </a>
            </div>
        </div>
    </nav>

    <!-- LEFT NAV -->
    <div class="nav-column">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="/ras/posts">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ras/eventposts">Events</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ras/bans">Bans</a>
            </li>
            <li class="nav-item" style="font-weight: bold;">
                <a class="nav-link" href="/ras/directory">Directory</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#signoutModal">Sign Out</a>
            </li>
        </ul>
    </div>

    <!-- PROFILE CARD -->
    <div class="card-wrapper">
        <div class="card" style="padding: 24px;">
            <#if ra??>
                <h1>${ra.name}</h1>
                <h5>@${ra.username} | ${ra.residenceDescription}</h5>
                <p>${ra.email}</p>
                <a href="/ras/directory" class="btn btn-outline-custom btn-sm mt-2">Back to Directory</a>
            <#else>
                <p>RA not found.</p>
            </#if>
        </div>
    </div>




    <!-- SIGN OUT MODAL -->
    <div class="modal fade" id="signoutModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Sign Out</h5>
                </div>
                <div class="modal-body">
                    Are you sure you want to sign out?
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
