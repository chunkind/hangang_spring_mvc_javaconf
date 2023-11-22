const popupBg = document.querySelector('.popupBg');
const popup = document.querySelector('.popup');
const fn_search = ()=>{
	Util.ajax({
		url : "/ftree/ftreeList.do",
		data : {},
		fn_success : function(d){
			dataList = d.list;
			console.log(`dataList:${dataList}`)
		}
	});
}

let dataList = [];

popupBg.addEventListener('click', (e)=>{
	e.preventDefault();
	popupBg.classList.toggle('inactive');
});

popup.addEventListener('click', (e)=>{
	e.stopPropagation();
});

function openPopup(popType, vtcLvl, hrzLvl, fmlyIdx){
	let title = '';
	let url = '';

	if(popType == 'edit'){
		title = "족보수정";
		url = '/fo/ftree/ftreeEdit.do';
	}else if(popType == 'rgst'){
		title = "족보등록";
		url = '/fo/ftree/ftreeRegister.do';
	}
	fetch(url)
		.then((response)=>{
			response.text().then((text)=>{
				popupBg.classList.toggle('inactive');
				document.querySelector('#popupTitle').innerHTML = title;
				document.querySelector('#popupContent').innerHTML = text;
				document.querySelector('#vtcLvl').value = vtcLvl;
				document.querySelector('#hrzLvl').value = hrzLvl;
				document.querySelector('#ftreeFmlySeq').value = fmlyIdx;
			});
		})
		.catch((error)=>{
			console.log(error);
		});
}

function fn_preview_img(){
	let reader = new FileReader();
	reader.onload = function(event) {
		let img = document.querySelector("#imgPreView img");
		if(null!=img){
			document.querySelector("#imgPreView img").remove();
		}
		img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		img.setAttribute("width", "300px");
		//img.setAttribute("height", "");
		document.querySelector("#imgPreView").appendChild(img);
	};
	reader.readAsDataURL(event.target.files[0]);
}

function fn_clear(){
	let img = document.querySelector("#imgPreView img");
	if(null!=img){
		document.querySelector("#imgPreView img").remove();
	}
}

function fn_register(){
	let frm = document.querySelector('#frm');
	let lvlType = document.querySelector('#lvlType').value;
	let vtcLvl = document.querySelector('#vtcLvl').value;
	let hrzLvl = document.querySelector('#hrzLvl').value;
	let formData = new FormData(frm);

	if(lvlType == '01'){
		//배우자
		document.querySelector('#vtcLvl').value = vtcLvl + 1;
	}else if(lvlType == '02'){
		//자식
		document.querySelector('#hrzLvl').value = hrzLvl + 1;
	}

	let _xml = new XMLHttpRequest();
	_xml.open('POST', '/tfree/ftreeRegisterAct.do', true);
	_xml.onload = function (event){
		if(_xml.status == 200){
			console.log(event);
		}else{
			console.log('error...');
		}
		document.querySelector('#vtcLvl').value = '';
		document.querySelector('#hrzLvl').value = '';
		document.querySelector('#ftreeFmlySeq').value = '';
		popupBg.classList.toggle('inactive');
	}
	_xml.send(formData);
}

/*
function fn_register(){
	let frm = document.querySelector('#frm');
	frm.action = '/tfree/ftreeRegisterAct.do';
	frm.submit();
}
*/