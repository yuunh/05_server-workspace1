<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        div{box-sizing: border-box;}
        #footer {
            /* border: 2px solid black; */
            width: 1000px;
            height: 150px;
            
        }
        #footer>div {
            height: 100%;
            text-align: center;
        }
        .ft {
            border: 1px solid lightgray;
            width: 25%;
            float: left;
            padding: 5px;
            border-bottom: white;
            border-top: white;
        }
        
        #f1 {
            width: 1000px;
            border: 7px solid #E0BFE6;
            border-bottom: white;
            border-left: white;
            border-right: white;
            padding-bottom: 10px;
        }

    </style>
</head>
<body>
    <div id="f1"></div>
    <div id="footer">
        <div class="ft" style="border-left: white;">
            <h4>전화 문의(9시~16시)</h4>
            <h4 style="font-weight: lighter;">
                1588-1588
            </h4>
        </div>
        <div class="ft">
            <h4>고객센터 미운영시간 안내 </h4>
            <h4 style="font-weight: lighter;">
                점심시간(12시~13시) <br>
                (토/일, 공휴일은 휴무)
            </h4>
        </div>
        <div class="ft">
            <h4>약관 및 정책 안내 </h4>    
            <h4 style="font-weight: lighter;"> 
                개인정보처리방침 <br>
                이용약관 <br>
                사업자 정보 확인
            </h4>
        </div>
        <div class="ft" style="border-right: white;">
            <img src="KakaoTalk_20230125_155420836.png" alt=".." width="100%" style="padding: 20% 10%;" >        
        </div>
    </div>
</body>
</html>