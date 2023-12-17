'use strict' //자바스크립트의 미친짓을 제한한다.

function pageMove(pageName, searchSaleBoardSeq){
   if(pageName == 'product'){
        location.href = '/cltsh/goods/goodsDetail.do?searchSaleBoardSeq=' + searchSaleBoardSeq;
    }
}

function fn_add_basket(salesSeq){
    if(confirm("해당 상품을 장바구니에 담으시겠습니까?")){
        fn_ajax({
            url:'/cltsh/order/orderCartInsertAjax.do?searchSaleBoardSeq=' + salesSeq,
            method:'get',
            success: function(data){
                let resultCode = data.result;
                if(resultCode == 'success'){
                    alert('장바구니에 상품이 담겼습니다.');
                }
            }
        });
    }
}


function fn_ajax(obj){
    let url = obj.url;
    let method = obj.method;
    let params = obj.params;
    let fn_success = obj.success;

    let httpRequest = new XMLHttpRequest();
    if(!httpRequest) {
        alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
        return false;
    }
    httpRequest.onreadystatechange = ()=>{
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status === 200) {
                let res = httpRequest.responseText;
                fn_success(JSON.parse(res));
            } else {
            	console.log(`code: ${httpRequest.status}`);
            	console.log(`message: ${httpRequest.responseText}`);
                alert('request에 뭔가 문제가 있어요.');
            }
        }
    };
    httpRequest.open(method, url);
    /* httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); */
    if(method == 'get' || method =='GET'){
    	httpRequest.send();
    }else{
    	httpRequest.setRequestHeader('Content-Type', 'application/json');
    	httpRequest.send(params);
    }
    
}
