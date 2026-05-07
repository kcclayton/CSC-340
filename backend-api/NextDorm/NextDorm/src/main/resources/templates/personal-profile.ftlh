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
    <!-- LEFT NAV OPTIONS -->

    <div class="nav-column">

        <!-- MAIN NAV BUTTONS -->

        <ul class="navbar-nav me-auto mb-2 mb-lg-0">

            <!-- HOME BUTTON -->

            <li class="nav-item">
                <a class="nav-link" href="/students">Home</a>
            </li>
            <!-- EVENTS BUTTON -->

            <li class="nav-item">
                <a class="nav-link" href="/students/events">Events</a>
            </li>

           <li class="nav-item">
                <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#signoutModal">Sign Out</a>
            </li>

    </div>

    <!--Profile section-->
     <div class="card-wrapper">
        <div class="card">
            <h1>${student.name}</h1>
            <h5>@${student.username} | ${student.residenceHall}</h5>
            
      
            <p>${student.description}</p>


            <form id="edit-profile" action="/students/update/${student.userId}" method="post">
                <label class="form-label">ID #</label>
                <input type="text" class="form-control" id="userId" name="userId" value="${student.userId}" readonly />

                <label class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${student.name}" placeholder="Name" />

                <label class="form-label">Username</label>
                <input type="text" class="form-control" id="username" name="username" value="${student.username}" placeholder="Username" />

                <label class="form-label">Residence Hall</label>
                <input type="text" class="form-control" id="residenceHall" name="residenceHall" value="${student.residenceHall}" placeholder="Residence Hall" />
                
                <label class="form-label">Description</label>
                <input type="text" class="form-control" id="description" name="description" value="${student.description}" placeholder="Short description" />
                <br>
                
                <button id = "submit" type="submit" class="btn btn-success">Save</button>
            </form>

                <form action="/students/delete" method="post">
                    <button type="submit" class="btn btn-danger"
                        onclick="return confirm('Permanently delete your account? This cannot be undone.')">
                        Delete My Account
                    </button>
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
                    <a href="/students/auth/signout" class="btn btn-outline-custom">I'm Sure</a>
                </div>
            </div>
        </div>
    </div>



    
</body>
</html>