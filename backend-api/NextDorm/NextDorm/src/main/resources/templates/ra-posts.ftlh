<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    <link rel="icon" href="/Images/nextdorm-logo-alt2.png" type="image/png">
    <link rel="stylesheet" href="/dashboard.css">
</head>
<body>

    <!-- NAVBAR -->
    <nav class="navbar navbar-expand-lg ra-navbar">
        <div class="container-fluid">
            <a class="navbar-brand" href="/ras/posts">
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
                <a class="nav-link" href="/ras/posts">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ras/eventposts">Events</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ras/bans">Bans</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ras/directory">Directory</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#signoutModal">Sign Out</a>
            </li>
        </ul>
    </div>

    <!-- MAIN CONTENT -->
    <div class="main-container">
        <div class="main-wrapper">
            <div class="thing">

                <ul class="container" id="filter-btn-container">
                    <li class="feed-btn">
                        <a class="nav-link" href="/ras/posts"><b>All</b></a>
                    </li>
                    <li class="feed-btn">
                        <a class="nav-link" href="#">Important</a>
                    </li>
                </ul>

                <div class="card home-feed mx-3">

                    <#list commentsList as post>
                    <div class="card post mx-4 my-2">

                        <ul class="container card-top-section">
                            <li class="card-title post-title">${post.postTitle!""}</li>
                            <li class="title-info">
                                <#if post.student??>${post.student.username}<#else>unknown</#if>
                                | ${post.createdAt!""}
                            </li>
                            <li class="comment-btn">
                                <a href="/students/replies/create/${post.postID}">
                                    <img src="/Images/comment-icon.png" alt="Reply" width="30" height="30" class="d-inline-block align-text-top">
                                </a>
                            </li>
                        </ul>

                        <p class="card-text"><b>${post.postTag!""}</b> | ${post.postContent!""}</p>

                        <#list post.replies as reply>
                        <div class="card-body" id="fixt-link" style="border-top: rgb(215, 215, 215) solid 1px">
                            <div class="container comment">
                                <p class="comment-info">
                                    <#if reply.student??>${reply.student.username}<#else>unknown</#if>
                                    | ${reply.createdAt!""}
                                </p>
                            </div>
                            <p class="comment-text">${reply.replyContent!""}</p>
                        </div>
                        </#list>

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
                    <a href="/ras/signout" class="btn btn-outline-custom">I'm Sure</a>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
