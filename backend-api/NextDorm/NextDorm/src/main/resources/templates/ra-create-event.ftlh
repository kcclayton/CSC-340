<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create an Event</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/create-post.css">
</head>
<body>

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

    <div class="nav-column">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item"><a class="nav-link" href="/ras/dashboard">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="/ras/bans">Bans</a></li>
            <li class="nav-item"><a class="nav-link" href="/ras/directory">RA Directory</a></li>
            <li class="nav-item"><a class="nav-link" href="/ras/signout">Sign Out</a></li>
        </ul>
    </div>

    <div class="card-wrapper">
        <div class="card">

            <form action="/ras/events/create" method="post">

                <div class="mx-3 mb-3">
                    <label class="form-label">Create an Event</label>
                    <input type="text" class="form-control" name="description" placeholder="Event description">
                </div>

                <div class="mx-3 mb-3">
                    <input type="text" class="form-control" name="organizationName" placeholder="Organization name">
                </div>

                <div class="mx-3 mb-3">
                    <input type="text" class="form-control" name="eventDate" placeholder="Event date (e.g. 2025-04-30)">
                </div>

                <div class="mx-3 mb-3">
                    <input type="text" class="form-control" name="location" placeholder="Location">
                </div>

                <button type="submit" class="btn btn-outline-custom" id="post-btn">Save</button>

            </form>

        </div>
    </div>

</body>
</html>
