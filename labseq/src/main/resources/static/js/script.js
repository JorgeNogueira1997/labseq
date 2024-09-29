$(document).ready(function() {

    $('#submitLabseq').on('click', function() {
        var userNumber = $("#nNumber").val();
        console.log("userNumber:", userNumber);

        // http://localhost:8080/labseq?n=50
        if(userNumber >= 0){
            var redirecionaURL = 'http://localhost:8080/labseq?n='+userNumber;
            location.href = redirecionaURL;

            // for some reason i can't make the below code to work :(
            // having problems with CORS and the WebController also does not work
            // http://localhost:8080/
            // http://localhost:63343/
            // ^ both show error when acessing

            // $.ajax({
            //     url: 'http://localhost:8080/labseq',
            //     type: 'GET',
            //     dataType: 'text',
            //     data: {
            //         n: userNumber,
            //     },
            //     success: function(x){
            //         console.log("Success!" + x);
            //     },
            //     error: function(request, status, error) {
            //         console.log("Erro [script.js] - /labseq/: " + error);
            //     }
            // }); // aJax
        }

    }); // onClick
}); // document ready