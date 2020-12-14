$(document).ready(function(){
    $('input[type="radio"]').click(function(){
        var inputValue = $(this).attr("value");
        var targetBox = $("." + inputValue);
        $(".disabledtext").prop('disabled', true);
        $(targetBox).prop('disabled', false);
        
    });
});