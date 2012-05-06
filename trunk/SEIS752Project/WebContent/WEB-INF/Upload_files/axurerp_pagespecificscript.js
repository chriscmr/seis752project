
var PageName = 'Upload';
var PageId = 'p457f6dcfa58447198d97800b8f75590f'
var PageUrl = 'Upload.jsp'
document.title = 'Upload';

if (top.location != self.location)
{
	if (parent.HandleMainFrameChanged) {
		parent.HandleMainFrameChanged();
	}
}

var $OnLoadVariable = '';

var $CSUM;

var hasQuery = false;
var query = window.location.hash.substring(1);
if (query.length > 0) hasQuery = true;
var vars = query.split("&");
for (var i = 0; i < vars.length; i++) {
    var pair = vars[i].split("=");
    if (pair[0].length > 0) eval("$" + pair[0] + " = decodeURIComponent(pair[1]);");
} 

if (hasQuery && $CSUM != 1) {
alert('Prototype Warning: The variable values were too long to pass to this page.\nIf you are using IE, using Firefox will support more data.');
}

function GetQuerystring() {
    return '#OnLoadVariable=' + encodeURIComponent($OnLoadVariable) + '&CSUM=1';
}

function PopulateVariables(value) {
  value = value.replace(/\[\[OnLoadVariable\]\]/g, $OnLoadVariable);
  value = value.replace(/\[\[PageName\]\]/g, PageName);
  return value;
}

function OnLoad(e) {

}

var u20 = document.getElementById('u20');
gv_vAlignTable['u20'] = 'top';

var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'center';
var u27 = document.getElementById('u27');
gv_vAlignTable['u27'] = 'top';
var u6 = document.getElementById('u6');
gv_vAlignTable['u6'] = 'top';
var u4 = document.getElementById('u4');

var u2 = document.getElementById('u2');

var u10 = document.getElementById('u10');

var u0 = document.getElementById('u0');

var u26 = document.getElementById('u26');

var u29 = document.getElementById('u29');

var u8 = document.getElementById('u8');

u8.style.cursor = 'pointer';
if (bIE) u8.attachEvent("onclick", Clicku8);
else u8.addEventListener("click", Clicku8, true);
function Clicku8(e)
{

if (true) {
    alert("u8 called");
	NewWindow("FAQ.jsp" + GetQuerystring(), "", "directories=0, height=500, location=0, menubar=0, resizable=1, scrollbars=1, status=0, toolbar=0, width=500", true, 500, 500);

}

}

var u14 = document.getElementById('u14');

u14.style.cursor = 'pointer';
if (bIE) u14.attachEvent("onclick", Clicku14);
else u14.addEventListener("click", Clicku14, true);
function Clicku14(e)
{

if (true) {

	self.location.href="Resources/reload.html#" + encodeURI(PageUrl + GetQuerystring());

}

}
gv_vAlignTable['u14'] = 'top';
var u28 = document.getElementById('u28');

var u33 = document.getElementById('u33');

u33.style.cursor = 'pointer';
if (bIE) u33.attachEvent("onclick", Clicku33);
else u33.addEventListener("click", Clicku33, true);
function Clicku33(e)
{

if (true) {

	self.location.href="Home.jsp" + GetQuerystring();

}

}
gv_vAlignTable['u33'] = 'top';
var u22 = document.getElementById('u22');
gv_vAlignTable['u22'] = 'top';
var u13 = document.getElementById('u13');

u13.style.cursor = 'pointer';
if (bIE) u13.attachEvent("onclick", Clicku13);
else u13.addEventListener("click", Clicku13, true);
function Clicku13(e)
{

if (true) {

	self.location.href="Home.jsp" + GetQuerystring();

}

}
gv_vAlignTable['u13'] = 'top';
var u12 = document.getElementById('u12');

var u21 = document.getElementById('u21');

var u7 = document.getElementById('u7');
gv_vAlignTable['u7'] = 'top';
var u17 = document.getElementById('u17');

u17.style.cursor = 'pointer';
if (bIE) u17.attachEvent("onclick", Clicku17);
else u17.addEventListener("click", Clicku17, true);
function Clicku17(e)
{

if (true) {

	self.location.href="Log_Out.jsp" + GetQuerystring();

}

}
gv_vAlignTable['u17'] = 'top';
var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'center';
var u15 = document.getElementById('u15');

var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'center';
var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u25 = document.getElementById('u25');

var u16 = document.getElementById('u16');
gv_vAlignTable['u16'] = 'top';
var u19 = document.getElementById('u19');
gv_vAlignTable['u19'] = 'top';
var u9 = document.getElementById('u9');
gv_vAlignTable['u9'] = 'center';
var u30 = document.getElementById('u30');

//u30.style.cursor = 'pointer';
//if (bIE) u30.attachEvent("onclick", Clicku30);
//else u30.addEventListener("click", Clicku30, true);
//function Clicku30(e)
//{
//if (true) {
//   alert("u30 clicked");
//	NewWindow("fileUpload.html" + GetQuerystring(), "", "directories=0, height=500, location=0, menubar=0, resizable=1, scrollbars=1, status=0, toolbar=0, width=500", true, 500, 500);
//
//}
//
//}


var u24 = document.getElementById('u24');
gv_vAlignTable['u24'] = 'top';
var u18 = document.getElementById('u18');

var u32 = document.getElementById('u32');
gv_vAlignTable['u32'] = 'center';
var u23 = document.getElementById('u23');
gv_vAlignTable['u23'] = 'top';
if (window.OnLoad) OnLoad();



	
//var u31 = document.getElementById('u31');
//u31.style.cursor = 'pointer';
//if (bIE) u31.attachEvent("onclick", Clicku31);
//else u31.addEventListener("click", Clicku31, true);
//function Clicku31(e)
//{
//if (true) {
//alert("Clicku31 Upload Button forward to Login_Page");
////	self.location.href="Login_Page.jsp" + GetQuerystring();
//var u18 = document.getElementById('u18');
//var u21 = document.getElementById("u21");
//var u26 = document.getElementById("u26");
//var u25 = document.getElementById("u25");
//var u29 = document.getElementById("u29");
//alert("file u29 " + u29.value);
//var mike = PopulateVariables(u29.value);
//alert(mike);
//
//	self.location.href="Upload" +"?title=" + u18.value + "&subject=" + u21.value + "&grade=" + u26.value + "&description=" + u25.value  + "&file=" + u29.value;
//	// later on going to Upload.jsp
//}
//
//}
var u34 = document.getElementById('u34');
