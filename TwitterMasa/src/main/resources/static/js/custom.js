$(document).ready(function () {
    // Like button
    $('button[class="likes btn btn-link"]').click(function () {
        var postId = $(this).attr('data-post-id');
        var $btn = $(this);
        $.ajax({
            type: 'POST',
            url: '/home/plusl',
            data: { id: postId },
            contentType: 'application/json',
            success: function (response) {
                $btn.find('i').text(' ' + response.l_count);
            },
            error: function () {
                alert('LikeFail')
            }
        })
    })

    $('button[class="reposts btn btn-link"]').click(function () {
        var postId = $(this).attr('data-post-id');
        var $btn = $(this);
        $.ajax({
            type: 'POST',
            url: '/home/plusr',
            data: { id: postId },
            contentType: 'application/json',
            success: function (response) {
                $btn.find('i').text(' ' + response.r_count);
            },
            error: function () {
                alert('RepostFail')
            }
        })
    })
});
