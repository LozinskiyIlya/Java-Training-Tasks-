$(document).ready(function () {
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
});


//  $('#btnPostLike').click(function () {