<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品中心--固收类理财</title>
</head>
		
		<link href="/YJLC_E/font/productFiles/iconfont.css" rel="stylesheet" type="text/css">
		<link href="/YJLC_E/font/productFiles/common.css" rel="stylesheet">
		<link href="/YJLC_E/font/productFiles/jw.css" rel="stylesheet">
		<script src="/YJLC_E/font/productFiles/hm.js"></script><script src="productFiles/jquery.js"></script>
		<script type="text/javascript" src="/YJLC_E/font/productFiles/layer.js"></script><link rel="stylesheet" href="productFiles/layer.css" id="layui_layer_skinlayercss">
		<script src="/YJLC_E/font/productFiles/echarts.js"></script><script data-require-id="echarts/chart/pie" src="/YJLC_E/font/productFiles/pie.js" async=""></script><style>@font-face{font-family:uc-nexus-iconfont;src:url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.woff) format('woff'),url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.ttf) format('truetype')}</style></head>
				

<body>
<jsp:include page="/WEB-INF/jsp/fontTop.jsp"></jsp:include>
	
	
	<!-- 示例-970 -->
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>
  
</div>
			<h3 class="w3_agile_head">产品中心</h3>
			<p class="augue_agile">We are all IT elites</p>
			
<div style="margin-top: 15px;">

<!-- 示例-970 -->
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>
  
</div>
	
	
	
	

<script type="text/javascript">
    $(function(){
        function showIn(url){
            var info="<div class='mydig'><div class='bg'></div><div class='imgbox'><a href="+url+"></a></div></div>";
            $('body').append(info);
        }

    });

</script>    

    <div class="proMain">
    	<div class="hwpzNav">
    		<ul>
    			<li class="first"><a class="active" href="">固收类理财</a></li>
    			<li class="second"><a href="">私募基金</a></li>
    			<li class="three"><a href="">海外配置</a></li>
    			<li class="four"><a href="">股权基金</a></li>
    		</ul>
    	</div>
        <div class="sdShaix">
        	<ul>
            	<li class="first">标的类型：</li>
               		<li><a href="" id="11" class="select">全部</a></li>
               		<li><a href="" id="12">固收类理财</a></li>
               		<li><a href="" id="13">车盈宝</a></li>
            </ul>
        	<ul>
            	<li class="first">年化收益：</li>
               		<li><a href="" id="21" class="select">全部</a></li>
               		<li><a href="" id="22">6.0%</a></li>
               		<li><a href="" id="23">7.0%</a></li>
               		<li><a href="" id="24">7.5%</a></li>
               		<li><a href="" id="25">8.0%</a></li>
               		<li><a href="" id="25">8.0%以上</a></li>
            </ul>
        	<ul>
            	<li class="first">项目期限：</li>
               		<li><a href="" id="31" class="select">全部</a></li>
               		<li><a href="" id="32">15天以下</a></li>
               		<li><a href="" id="33">15-30天</a></li>
               		<li><a href="" id="34">30-180天</a></li>
               		<li><a href="" id="35">180-365天</a></li>
               		<li><a href="" id="36">一年以上</a></li>
            </ul>
        	<ul>
            	<li class="first">标的状态：</li>
               		<li><a href="" id="41" class="select">全部</a></li>
               		<li><a href="" id="42">投标中</a></li>
               		<li><a href="" id="43">还款中</a></li>
               		<li><a href="" id="44">已完成</a></li>
            </ul>
        </div>



<div class="ajaxContainer">
	<!-- 异步内容开始 -->
					<ul class="tbList">
						<li class="first">
									<span class="ico zq"></span>
							<h2><em>投</em>稳盈宝新手标</h2>
							<i></i>
						</li>
						<li class="second">					
							
							<div class="txt1">
								<h2>5.0<span style="font-size:18px;">+1.0%</span></h2>
								<p>年化收益</p>
							</div>
							
							<div class="txt2">
								<h2>￥100.00</h2>
								<p>起购金额(元)</p>
							</div>
							
							<div class="txt2">
								<h2>5天</h2>
								<p>投资期限</p>
							</div>
						</li>
						<li class="three">
								<a href="">企业担保</a><span>中国人保财险承保</span>
								<p>计息日期：当天投资，立即计息<br>已购人数：689人</p>
						</li>
						<li class="four">
								
						</li>
						<li class="five">
							<a class="abtn" href="/YJLC_E/users/productbuy">购买</a>
						</li>
					</ul>



	<!-- 异步内容结束 -->
	
	

<script type="text/javascript">
	function getJsonInfo(url) {
		$.get(url, 'json', function(data) {
			$(".ajaxContainer").empty();
			$(".ajaxContainer").append(data);
		});
	}
		require.config({
            paths: {
                echarts: '/resources/web/echart/dist/'
            }
        });
		require(
			[
				'echarts',
				'echarts/chart/pie'
			],
			function (ec) {
				var labelTop = {
						normal : {
							color:'#ff503f',
							label : {
								show : false,
								position : 'center',
								formatter : '{b}',
								textStyle: {
									baseline : 'bottom'
								}
							},
							labelLine : {
								show : false
							}
						}
					};
				var labelFromatter = {
					normal : {
						label : {
							formatter : function (params){
								return 100 - params.value + '%'
							},
							textStyle: {
								color:'#666',
								baseline : 'middle'
							}
						}
					},
				};
				var labelBottom = {
					normal : {
						color: '#f8f8f8',
						label : {
							show : true,
							position : 'center'
						},
						labelLine : {
							show : false
						}
					}
				};
				var radius = [30,35];
				var myChart1 =document.getElementsByClassName('yuan');
				for(i=0;i<myChart1.length;i++){
					var num = myChart1[i].getAttribute('data-num');
					ec.init(myChart1[i]).setOption({
						series : [
							{
								type : 'pie',
								center : ['50%', '50%'],
								radius : radius,
								x: '0%', // for funnel
								itemStyle : labelFromatter,
								data : [
									{name:'other', value:100-num, itemStyle : labelBottom},
									{name:'占比', value:num,itemStyle : labelTop}
								]
							},
						]
					});
				}
			}
		);
    </script>   
   </div>
   

</div>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?06cf97732baac1a65bed8ae95f2384aa";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script><script type="text/javascript">
$(function(){
	$('#11').addClass("select");
	$('#21').addClass("select");
	$('#31').addClass("select");
	$('#41').addClass("select");
});
</script>

<div style="margin-top: 15px;">

<!-- 示例-970 -->
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>
  
</div>	

 <center>
<br><br>
<div style="height: 150px;width: 975px;background: url(/YJLC_E/font/img/fk.png);"></div>	
<br>
<br>	
</center> 



<div style="margin-top: 15px;">

<!-- 示例-970 -->
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>
  
</div>	

<div style="width: 100%;height:659px ;background: url(/YJLC_E/font/img/fontDown01.png);"  >

</div>	

</body>


</html>