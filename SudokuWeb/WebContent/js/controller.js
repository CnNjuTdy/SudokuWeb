var N = 3;
var DRAW_BOUNDS = [80, 0, 480, 480];

var shudu;//��������
var currentPos;//��ǰλ��
var canvas;//����

function main(){
    shudu = new Shudu(N, 0);
    canvas = document.getElementById("canvas");

    canvas.addEventListener("click", selectGrid, true);
    window.addEventListener("keydown", insertNum, true);
    draw();
}

//ѡ��Ԫ��
function selectGrid(event){
    var posX = event.pageX - canvas.offsetTop;
    var posY = event.pageY - canvas.offsetLeft;

    //�ж�ѡ�е�λ��
    var tmpPos = toPos(posX, posY);
    if(tmpPos == null)
	return;
    currentPos = shudu.visible(tmpPos[0], tmpPos[1])?currentPos:tmpPos;
    draw();
}

//��д����
function insertNum(event){
    var numStart = 48;

    if(currentPos == null)
	return;

    if(event.keyCode > numStart && event.keyCode <= numStart + 9){
		var num = event.keyCode - numStart;
		shudu.insert(num, currentPos);
    }
    else if(event.keyCode == 9){
		var x = currentPos[0];
		var y = currentPos[1];
		alert(x+" "+y);
		if(x==8){
			if(y==8){
				return;
			}
			currentPos = [0,y+1]
		}
		else{
			currentPos = [x+1,y]
		}
    }

    draw();
    if(event.keycode == 9){
    	insertNum(event);
    }
}

//�ж��Ƿ��ڻ�ͼ������
function inDrawRange(x, y){
    if(x < DRAW_BOUNDS[0] || y < DRAW_BOUNDS[1])
	return false;

    if(
	DRAW_BOUNDS[2] + DRAW_BOUNDS[0] <= x ||
	DRAW_BOUNDS[3] + DRAW_BOUNDS[1] <= y
    )
	return false;

    return true;
}

//������ת��Ϊλ��
function toPos(x, y){
    if(!inDrawRange(x, y))
	return currentPos;

    var CEIL_W = DRAW_BOUNDS[2]/(N*N);
    var CEIL_H = DRAW_BOUNDS[3]/(N*N);

    var posX = Math.floor((x - DRAW_BOUNDS[0])/CEIL_W);
    var posY = Math.floor((y - DRAW_BOUNDS[1])/CEIL_H);

    return [posX, posY];
}
