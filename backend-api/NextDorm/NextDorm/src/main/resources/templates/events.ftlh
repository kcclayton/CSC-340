<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RA Events</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/dashboard.css">
</head>
<body>

    <!-- NAVBAR -->
    <nav class="navbar navbar-expand-lg ra-navbar">
        <div class="container-fluid">
            <a class="navbar-brand" href="/students">
                <img src="/Images/nextdorm-logo-alt3.png" alt="Logo" width="155" height="55" class="d-inline-block align-text-top">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <form class="d-flex navbar-search" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                    <button class="btn btn-outline-custom" type="submit">Search</button>
                </form>
                <a class="navbar-icon ms-auto" id="profile-icon" href="/students/profile">
                    <img src="/Images/nextdorm-icon-profile.png" alt="Profile" width="60" height="60" class="d-inline-block align-text-top">
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

            <li class="nav-item" style="font-weight: bold;">
                <a class="nav-link" href="events.html">Events</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#signoutModal">Sign Out</a>
            </li>

    </div>


    <!-- MAIN CONTENT -->
    <div class="main-container">
        <div class="main-wrapper">
            <div class="thing">


                <!-- EVENT FEED -->
                <h2 id="events-heading">Current Events:</h2>
                <br>
                <div class="card home-feed mx-3">

                    <#list eventsList as event>
                    <div class="card post mx-4 my-2">

                        <ul class="container card-top-section">
                            <li class="card-title post-title">${event.description}</li>
                            <li class="title-info">${event.organizationName} | ${event.eventDate} | ${event.location}</li>
                        </ul>

                        <p class="card-text event-info"></p>

                    </div>
                    </#list>

                </div>

            </div>
        </div>
    </div>

    <!-- QUICK LINKS -->
    <div class="right-container">
        <div class="quick-links-feed">
            <div class="card quick-links">
                <div class="card-body" id="fixt-card">
                    <h5 class="card-title">Something broken?</h5>
                    <p class="card-text">Use this form for issues with physical equipment or systems.</p>
                </div>
                <div class="card-body" id="fixt-link" style="border-top: rgb(215, 215, 215) solid 1px">
                    <a href="https://uncg.webtma.com/Login/Validate/?tkn=g6Y25J6P4J0W32tK_JftRhAPjVpjq082kiulXBdor9j0S5lHhkW5q8SlpOO_rsnKUo8IJwwuTdmcR7nZA1DTeXx8IBqj6SvIjMmtD3GcdUHwU_BHSRq4RcfuSMDrsQoUgCt_tlvGkCjjmnuDabXrafABp0LGFY7fg9byqneZdGldqjDaUCKfE2eIyNGGYgX3EoYNXrm3D1C8YarQgyOACluyYuuw3SfZox-K5dHtaf3Dbe5sG4AAXB1RbiGA0MBSzBq9n73xRaWvHkQOvj83Dw"
                        class="card-link link-underline link-underline-opacity-0">Submit a work request here!</a>
                </div>
            </div>
            <div class="card quick-links">
                <div class="card-body" id="fixt-card">
                    <h5 class="card-title">Community Guidelines</h5>
                    <p class="card-text">See what all your campus has to offer.</p>
                </div>
                <div class="card-body" id="fixt-link" style="border-top: rgb(215, 215, 215) solid 1px">
                    <a href="https://hrl.uncg.edu" class="card-link link-underline link-underline-opacity-0">Visit the housing website here!</a>
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
                    <a href="/students/auth/signout" class="btn btn-outline-custom">I'm Sure</a>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
