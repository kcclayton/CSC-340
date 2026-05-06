<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RA Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/dashboard.css">
</head>
<body>

    <!-- NAVBAR -->
    <nav class="navbar navbar-expand-lg ra-navbar">
        <div class="container-fluid">
            <a class="navbar-brand" href="/ras/dashboard">
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
                <a class="navbar-icon" id="user-ban-icon" href="/ras/bans/create">
                    <img src="/Images/nextdorm-icon-user-ban-form.png" alt="Ban" width="60" height="60" class="d-inline-block align-text-top">
                </a>
                <a class="navbar-icon" id="profile-icon" href="/ras/profile">
                    <img src="/Images/nextdorm-icon-profile.png" alt="Profile" width="60" height="60" class="d-inline-block align-text-top">
                </a>
            </div>
        </div>
    </nav>

    <!-- LEFT NAV -->
    <div class="nav-column">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item" style="font-weight: bold;">
                <a class="nav-link" href="/ras/dashboard">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ras/bans">Bans</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ras/directory">RA Directory</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ras/signout">Sign Out</a>
            </li>
        </ul>
    </div>

    <!-- MAIN CONTENT -->
    <div class="main-container">
        <div class="main-wrapper">
            <div class="thing">

                <ul class="container" id="filter-btn-container">
                    <li class="feed-btn">
                        <a class="nav-link" href="/ras/dashboard"><b>All Events</b></a>
                    </li>
                    <li class="feed-btn">
                        <a class="nav-link" href="/ras/dashboard/my-events">My Events</a>
                    </li>
                    <li class="feed-btn" id="create-event">
                        <a class="nav-link" href="/ras/events/create">Create an Event</a>
                    </li>
                </ul>

                <!-- EVENT FEED -->
                <div class="card home-feed mx-3">

                    <#list eventsList as event>
                    <div class="card post mx-4 my-2">

                        <ul class="container card-top-section">
                            <li class="card-title post-title">${event.description}</li>
                            <li class="title-info">${event.organizationName} | ${event.eventDate} | ${event.location}</li>
                        </ul>

                        <p class="card-text event-info"></p>

                        <div class="d-flex gap-2 mx-3 mb-2">
                            <a href="/ras/events/edit/${event.eventId}" class="btn btn-outline-custom btn-sm">Edit</a>
                            <form action="/ras/events/delete/${event.eventId}" method="post" style="display:inline;">
                                <button type="submit" class="btn btn-danger btn-sm"
                                    onclick="return confirm('Delete this event?')">Delete</button>
                            </form>
                        </div>

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

</body>
</html>
