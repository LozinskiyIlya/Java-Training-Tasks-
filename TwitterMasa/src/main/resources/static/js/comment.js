$(document).ready(function () {
    $('button[class="comment btn btn-primary"]').click(function () {
        var postId = $(this).attr('data-post-id');
        // var txt = $('.textarea.form-control').text;
        // var t = JSON.stringify(txt);
        $.ajax({
            type: 'POST',
            url: '/home/newcomment',
            data: { id: postId },
            contentType: 'application/json',
            success: function (data) {
                // var author = $('.comment-author.col-auto.mr-auto');
                // var dat = $('.comment-date.col-auto.mr-auto');
                // var text = $('.comment-text.col-auto.mr-auto');
                // author.text(data.status);
                // dat.text(data.errorMessage);
                // text.text(data.r_count);
                                // $btn.find('i').text(' ' + response.r_count);
            alert('CommentSuccess')
            },
            error: function (response) {
                console.log(response);
                alert(response.responseJSON.message)
            }
        })
    })
});