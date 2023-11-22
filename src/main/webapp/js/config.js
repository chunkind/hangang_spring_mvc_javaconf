let isWebSocket = false;
let pretime = null;
let nowtime = null;
let screenTimeTick = 1000 / 60; /*화면그리는 속도 1초에 60 프레임*/
let dataTimeTick = 1000 / 60; /*데이터 받아오는 속도 1초에 60번*/

//위치정보
let latitude = '';
let longitude = '';

let whetherData = null;