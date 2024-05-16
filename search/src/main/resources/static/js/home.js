$(document).ready(function(){
    $('#search-btn').click(function(){
        let query = $('#search').val();

		$.get('/search?query='+query,function(data){
            console.log(data);
            let title = data.body.title  // 우리가 function을 통해 받아온 data의 body(Result Dto)의 title(Result Dto의 변수들) 의 값을 받아옴.
            let category = data.body.category
            let address = data.body.address;
            let roadAddress = data.body.roadAddress;
            let homepage = data.body.homepage;
            let image = data.body.image;

            $('#result-img').attr('src', image);  // attr

            $('#title').text(title);  // text
            $('#category').text(category);
            $('#address').text(address);
            $('#roadAddress').text(roadAddress);
            $('#homepage').attr('href',homepage);
        });
    });

    $('#add-btn').click(function(){
        let title = $('#title').text();
        let category = $('#category').text();
        let address = $('#address').text();

        console.log(title+", "+ category+", "+address);

        let obj = {
            "title":title,
            "category":category,
            "address":address
        };

        let jsonStr = JSON.stringify(obj);

        $.ajax({
            type : "POST",
            url : "/search/add",
            data : jsonStr,
            contentType : "application/json",
            success : function(res){
                console.log("add res --------------------");
                console.log(res);

                getMyList();
            }
        });
    });

    function getMyList(){
        $.get('/search/all', function(data){  // get 은 synchronized 통신이다. 비동기라서 응답이 오든말든 홀딩하지 않는다. 대신 콜백은 function 이 콜백함수가 되어서 실행된다.
            console.log(data);

            if(data.body.length > 0){
                $('#my-list').empty();

//              <table>
//              <tr>  // table row
//              <td></td><td></td><td></td> // table column 컬럼이 세개
//              <tr>
//              </table>

                let table = $('<table />');
                for(let index in data.body){
                    let idx = data.body[index].idx;
                    let title = data.body[index].title;
                    let category = data.body[index].category;
                    let address = data.body[index].address;

                    let innerHtml = "";
                    innerHtml += "<tr>"
                    innerHtml += "<td>"+idx+"</td>"
                    innerHtml += "<td>"+title+"</td>"
                    innerHtml += "<td>"+category+"</td>"
                    innerHtml += "<td>"+address+"</td>"
                    innerHtml += "</tr>"

                    table.append(innerHtml);
                }

            $('#my-list').append(table);
            }
        });
    }
});