<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购买固收类产品</title>
<link href="/YJLC_E/font/productFiles/iconfont.css" rel="stylesheet" type="text/css">
<link href="/YJLC_E/font/productFiles/common.css" rel="stylesheet">
<link href="/YJLC_E/font/productFiles/jw.css" rel="stylesheet">
<script src="/YJLC_E/font/productFiles/hm.js"></script>
<script src="productFiles/jquery.js"></script>
<script type="text/javascript" src="/YJLC_E/font/productFiles/layer.js"></script>
<link rel="stylesheet" href="productFiles/layer.css" id="layui_layer_skinlayercss">
<script src="/YJLC_E/font/productFiles/echarts.js"></script>
<script data-require-id="echarts/chart/pie" src="/YJLC_E/font/productFiles/pie.js" async=""></script>
<style>
@font-face {
	font-family: uc-nexus-iconfont;
	src:
		url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.woff)
		format('woff'),
		url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.ttf)
		format('truetype')
}
</style>
</head>



</head>


<body>
	<jsp:include page="/WEB-INF/jsp/fontTop.jsp"></jsp:include>


	<!-- 示例-970 -->
	<ins class="adsbygoogle" style="display: inline-block; width: 970px; height: 90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>
  	<h3 class="w3_agile_head">购买固收类产品</h3>
	<p class="augue_agile">We are all IT elites</p>

<!-- 示例-970 -->
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>





<div class="proMain">
    <div class="conTit">
        <span><a style="color:#9d8440;" href="/YJLC_E/users/product">其他标的</a></span>
        <h2><em>￥</em>${subject.name}</h2>
    </div>
    <table class="conTable" width="100%" border="0" cellspacing="0" cellpadding="0">
        <tbody><tr>
            <td class="txtInfo">
                <div class="txt1">
                    <h2>${subject.bought}</h2>
                    <p>已购人数(人)</p>
                </div>
                <div class="txt2">
                    <h2>${subject.year_rate}</h2>
                    <p>年化收益</p>
                </div>
                <div class="txt1">
                    <h2>${subject.period}</h2>
                    <p>投资期限(天)</p>
                </div>
            </td>
            <td width="360" rowspan="2" align="center"  valign="middle" height="320">
                <div class="tbBox">
                    <input type="hidden" id="account" value="0">
                    <h2>${subject.amount}</h2>
                    <p>已投金额(元)</p>
                    <div class="li4" style="display: none;"><span id="checkmoney" style="color: red;"></span></div>
                    <div class="tit">
                    	<span class="fr">
                        <c:if test="${!empty member}">
                        ${ma.useable_balance}元&nbsp;&nbsp;
                        <a href="/YJLC_E/users/alipay">充值&nbsp;&nbsp;&nbsp;</a>
                        </c:if>
                        <c:if test="${empty member }">
                      		  登录后可见&nbsp;&nbsp; 
                      		  <a href="#small-dialog" class="play-icon popup-with-zoom-anim" >充值&nbsp;&nbsp;&nbsp;</a>
                        </c:if>
                        
						</span>
                        <h2>账户余额</h2>
                        <div id="count" style="">预期所得收益<i data-num="0.000822" id="num">0</i>元
                        </div>
                    </div>
<script type="text/javascript">
function tj(){
 	var a=parseFloat($("#qtje").val());//起投金额
	var b=parseFloat($("#mytext").val());//文本框输入的金额
	var j=parseFloat($("#jine").val());//账户余额
	if(j>=b){
		if(a>b){
			alert("该产品起投金额必须大于"+a);
		}else{
			alert("提交了");
			 $("#f1").attr("action","/YJLC_E/alipay/buygsl");
		     $("#f1").submit();	
		}
	}else{
		alert("账户余额不足,请充值!");
	}
}	
</script>                           
               <form  id="f1" method="post" action="/YJLC_E/alipay/buygsl">
                    
                    <c:if test="${!empty member}">
                    	<input type="hidden" id="jine" name="useable_balance" value="${ma.useable_balance}" ><!-- 账户余额 -->
                    	<input type="hidden" id="invest_amount" name="invest_amount" value="${ma.invest_amount}"><!-- 总金额 -->
                    	<input type="hidden" id="create_date" name="create_date" value="${ma.create_date}"><!-- 创建时间 -->
                    	<input type="hidden" id="member_id" name="member_id" value="${member.id}"><!-- 用户id -->
                    	<input type="hidden" id="imuseale_balance" name="imuseale_balance" value="${ma.imuseale_balance}"><!-- 冻结金额 -->
                    	<input type="hidden" id="total_profit" name="total_profit" value="${ma.total_profit }"><!-- 立即收益 -->
                    	<input type="hidden" id="bonus_amount" name="bonus_amount" value="${ma.bonus_amount}"><!-- 红包金额 -->
                    	<input type="hidden" id="delflag" name="delflag" value="${ma.delflag }">
                    	<input type="hidden" id="bbin_amount" name="bbin_amount" value="${ma.bbin_amount}"> <!-- 体验金 -->
                    	<input type="hidden" id="id" name="id" value="${ma.id}"> <!-- id -->
                    </c:if>
                    <input type="hidden" id="id" name="sid" value="${subject.id}">
                    <input type="hidden" id="zxc" name="hkrq1" value="${hkrq1}">
                    <input type="hidden" id="qtje" name=floor_amount value="${subject.floor_amount}" >
                    <input id="mytext" class="txt" name="totalFee" type="text" placeholder="起投金额  ${subject.floor_amount } 元以上" ">
                        <span style="float: right;margin-top: -40px;position: relative; line-height: 40px; padding: 0 10px;color: #f00;" id="addMoney"></span>
                    <p class="preBox">
                        <input type="checkbox" id="registerRule" class="registerRule" checked="checked"><span class="fl">同意<a href="#" target="_black">《产品协议》</a></span>
                        <button id="redPacket">使用红包</button>
                            <button id="bbinAll">体验金全投</button>
                    </p>
                    <c:if test="${!empty member}">
                   		 <button id="ss" onclick="tj();">确认抢购</button>
                    </c:if>
                    
                    <c:if test="${empty member}">
                     <button class="layui-btn layui-btn-danger layui-btn-radius" disabled="disabled">登陆后抢购</button>                   		 
                    </c:if>
                    </form>
                    
                    
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <ul class="conInfoList">
                    <li class="info">
                        <p>计息日期：<font color="#00baff">${jxrq}</font></p>
                        <p>还款方式：<font color="#00baff">一次性还本付息</font></p>
                        <p>资金到账日：<font color="#00baff">${hkrq1}至${hkrq2}</font>
                        </p>
                    </li>
                    <li class="info">
                        <p>保障方式：<font color="#00baff">${subject.safeGuard_way}</font></p>
                        <p>资金安全：<font color="#00baff">中国人保财险承保</font></p>
                        <p></p>
                    </li>
                </ul>
            </td>
        </tr>
    </tbody></table>
    <div class="tbConBox">
<div class="layui-tab layui-tab-card">
  <ul class="layui-tab-title">
    <li class="layui-this">产品速览</li>
    <li>项目详情</li>
    <li>安全保障</li>
  </ul>
  
  
  <div class="layui-tab-content" style="height: 1100px;">
    <div class="layui-tab-item layui-show">
            <div id="conBox">
            <div class="box" style="display:block">
                <table class="dbwtab" width="100%" border="1" bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
                <tbody><tr>
                    <td class="corf9"><span>债权编号</span></td>
                    <td>JWYJ15091601</td>

                    <td class="corf9"><span>企业认证</span></td>
                    <td>杭州吉威投资管理有限公司</td>
                    </tr>
                    <tr>
                    <td class="corf9"><span>债权人</span></td>
                    <td>王进</td>

                    <td class="corf9"><span>保障平台</span></td>
                    <td>盈+理财</td>

                </tr>
                </tbody></table>
                <div style="border:solid 1px #e9e9e9; padding:15px; margin-top:5px;">
                
                
<style>
.fl{ float:left}
.fr{ float:right}
.productDetailCnt{
	padding:0 40px;
	width:800px; margin:0 auto
}

.productDetailCnt .listItem{
	padding:25px 0 30px;
	border-bottom:1px solid #e7e7e7
}

.productDetailCnt h3{
	font-size:20px;
	font-weight:400;
	margin-bottom:12px;
	line-height:32px
}

.productDetailCnt .listItem .detailIcon{
	display:inline-block;
	width:120px;
	height:120px;
	background-image:url(http://wacai-file.b0.upaiyun.com/finance/image/web/licai/wm/detailIcon.png);
	background-repeat:no-repeat
}

.productDetailCnt .listItem .fl{
	margin-right:42px;
	margin-left:12px
}

.productDetailCnt .listItem .fr{
	margin-right:12px;
	margin-left:42px
}

.productDetailCnt .row_1 .detailIcon{
	background-position:0 0
}

.productDetailCnt .row_2 .detailIcon{
	background-position:-120px 0
}

.productDetailCnt .row_3 .detailIcon{
	background-position:-240px 0
}

.productDetailCnt .row_4 .detailIcon{
	background-position:-360px 0
}

.productDetailCnt .row_5 .detailIcon{
	background-position:-480px 0
}

.productDetailCnt .row_1 .media-body,.productDetailCnt .row_3 .media-body,.productDetailCnt .row_5 .media-body{
	margin-right:12px
}

.productDetailCnt .row_2 .media-body,.productDetailCnt .row_4 .media-body{
	margin-left:12px
}

.productDetailCnt .listItem p{
	font-size:14px;
	color:#999;
	line-height:1.5
}

.productDetailCnt .tipRow,.projectDetailBox .tipRow{
	padding:20px 0
}</style><div class="productDetailCnt"><div class="pDetailList"><div class="listItem row_1"><div class="media"><span class="fl"><em class="detailIcon">&nbsp;</em></span><div class="media-body"><h3>安不安全</h3><p>本产品是中建投信托产品，上市公司宋都股份为该项目项下宋都集团的债务清偿提供连带责任保证责任，宋都股份为A股上市公司，浙江本地较大房地产企业，综合实力较强；</p><p>标的项目为杭州市区内刚需楼盘，销售情况较好；还款来源充足。</p><p>抵押物位于杭州桐庐大奇山郡未售现房，品质较高，抵押率不超过50%，抵押资产真实可靠。</p></div></div></div><div class="listItem row_2"><div class="media"><span class="fr"><em class="detailIcon">&nbsp;</em></span><div class="media-body"><h3>钱去哪了</h3><p>本产品由债权出让人购得中建投信托-安泉19号集合资金信托计划，用于宋都集团下属子公司香悦郡置业负责开发的杭州宋都香悦郡项目的开发建设。</p></div></div></div><div class="listItem row_3"><div class="media"><span class="fl"><em class="detailIcon">&nbsp;</em></span><div class="media-body"><h3>购买准备</h3><p>1. 首次购买需开通理财账户，理财账户可直接进行充值。</p><p>2. 了解申购所用银行卡支持情况，大额支付需要网银，支持银行数量和支付限额高；快捷支付方便迅速，但支持银行数量有限。</p><p>3. &nbsp;产品限量抢购，提前充值可以大大提升抢购成功率。</p></div></div></div><div class="listItem row_4"><div class="media"><span class="fr"><em class="detailIcon">&nbsp;</em></span><div class="media-body"><h3>怎样赎回</h3><p>产品到期后本金和收益将自动回款至您的理财账户，产品到期前暂不支持提前赎回。</p></div></div></div><div class="tipRow f12 g9">由于理财资金管理运用过程中，可能会面临多种风险因素，在您选择购买本理财产品前，请充分认识风险，谨慎投资</div></div></div></div>
            </div>

            <div class="box" style="display:none;">
            <p style="text-align:center"><strong><span style="font-size:21px;font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;">项目亮点</span></strong></p><p class="MsoListParagraph" style="margin-left:48px"><strong><span style=";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;"></span></strong></p><p>1、<strong>宋都股份为A股上市公司，浙江本地较大房地产企业，综合实力较强：</strong></p><p>截至2014年末，宋都股份总资产136.85亿元，总负债98.01亿元，资产负债率71.62%。宋都股份2014年全年主营业务收入约23.23亿元，净利润为0.55亿元，主要来源于房地产销售收入，销售净利率2.35%。2015年3月末，宋都股份主营业务收入约7.37亿元，净利润0.61亿元。根据预测，其未售存货按照目前的售价估算未来的可售金额可达到140亿元左右，结合其未来工程款投入压力较小的因素，宋都股份整体未来2年内的现金流对本信托计划有较好的保证能力。</p><p><br></p><p>2、<strong>标的项目为杭州市区内刚需楼盘，销售情况较好：</strong></p><p>目前项目工程进度至地上主体工程二分之一左右程度，截至2015年5月末，已推盘去化率（按套数）大约52%。由于属于纯刚需楼盘，项目目前销售情况良好，信托计划第一还款来源较为充足。</p><p><br></p><p>3、<strong>抵押物位于杭州桐庐大奇山郡未售现房，品质较高，抵押率不超过50%：</strong></p><p>大奇山郡置业拥有的位于杭州桐庐的大奇山郡项目已竣工未销售的现房资产或其他受托人认可的资产，抵押率不超过50%。</p><p class="MsoListParagraph" style="margin-left:48px"><span style=";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;"></span><br></p><p style="text-align:center"><strong><span style="font-size:21px;font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;">增信措施</span></strong></p><p><strong>连带责任保证担保</strong></p><p>上市公司宋都股份为本项目项下宋都集团的债务清偿提供连带责任保证责任。</p><p><br></p><p><strong>抵押担保</strong></p><p>大奇山郡置业以其持有的位于杭州桐庐的大奇山郡项目存量房产提供抵押担保或其他受托人认可的资产提供担保，抵押率不超过50%。</p><p><br></p><p><strong>资金归集</strong></p><p>1、销售资金归集</p><p>当目标项目可售货值&lt;全部信托贷款本金余额*1.5时，如宋都集团未提前一次性偿还全部信托贷款本金及利息，则自目标项目可售货值〈全部信托贷款本金余额*1.5之日起，目标项目销售回款（销售回款以所有按揭银行发放的按揭贷款流水金额以及宋都集团书面提供的首付款金额统计为准，下同）每满5000万元时，宋都集团应向归集账户归集资金人民币3500万元。</p><p>2、到期前归集</p><p>各期贷款到期日前20日，归集该期贷款本金余额的5%；各期贷款到期日前10日，归集至该期贷款本金余额的20%；各期贷款到期日，归集至该期贷款本金余额的100%。</p><p><br></p><p><strong>资金监管</strong></p><p>受托人委托商业银行作为本信托计划监管银行，对信托资金使用进行专项监管。</p><p><br></p>
            </div>
            <div class="box" style="display:none;">
            <p><strong>资金保障</strong></p><p>1.交易过程中盈+平台不触碰资金，资金在银行的监管下在银行账户间流动。</p><p>2.交易资金由招商银行全面监管。</p><p>3.资金流向清晰，资金安全有保障。</p><p><br></p><p><strong>本息保障</strong></p><p>1.资金最终投向中建投信托产品，基础资产风险几乎为零，安全有保障。</p><p>2.杭州吉威投资承担对该笔债权的回购义务，到期无条件偿付投资人本息。</p><p>3.盈+平台对资金真实投向中建投信托产品的过程提供保障。如果因资金没有流向中建投信托产品而发生损失，盈+平台100%全额赔付本息。</p><p><br></p><p><strong>盈+平台风控综述</strong></p><p>盈+平台通过与知名企业合作，利用互联网金融的高周转和灵活性，择时提供既能给盈主（平台客户）带来不错的收益，又能满足低资金成本需求的理财产品。</p>
            </div>
        </div>
    </div>
    
    
    <div class="layui-tab-item" style="width: 100%;height: 100%">
    	<div style="background: url(/YJLC_E/font/img/xmxq.png);width:100%;height: 1000px"></div>
    </div>
    
    
    <div class="layui-tab-item" style="width: 100%;height: 100%">
    	<div style="background: url(/YJLC_E/font/img/aqbz.png);width:100%;height: 450px"></div>
    </div>
    
</div>
</div>
    </div>
    
    <br><br><br><br>
    <div class="picList">
        认证文件展示
        <ul>
            <li><a href="/YJLC_E/font/productFiles/1442455557145.png"><img src="/YJLC_E/font/productFiles/1442455557145.png"></a></li>
            <li><a href="/YJLC_E/font/productFiles/1442455557158.png"><img src="/YJLC_E/font/productFiles/1442455557158.png"></a></li>
            <li><a href="/YJLC_E/font/productFiles/1442455557162.png"><img src="/YJLC_E/font/productFiles/1442455557162.png"></a></li>
            <li><a href="/YJLC_E/font/productFiles/1442455557165.png"><img src="/YJLC_E/font/productFiles/1442455557165.png"></a></li>
        </ul>
        <!-- <div style="clear:both;"></div> -->
    </div>

</div>


    
	

<div id="fancybox-tmp"></div>
<div id="fancybox-loading">
	<div></div>
</div>
<div id="fancybox-overlay"></div>
<div id="fancybox-wrap">
	<div id="fancybox-outer">
		<div class="fancybox-bg" id="fancybox-bg-n"></div>
		<div class="fancybox-bg" id="fancybox-bg-ne"></div>
		<div class="fancybox-bg" id="fancybox-bg-e"></div>
		<div class="fancybox-bg" id="fancybox-bg-se"></div>
		<div class="fancybox-bg" id="fancybox-bg-s"></div>
		<div class="fancybox-bg" id="fancybox-bg-sw"></div>
		<div class="fancybox-bg" id="fancybox-bg-w"></div>
		<div class="fancybox-bg" id="fancybox-bg-nw"></div>
		<div id="fancybox-content"></div>
		<a id="fancybox-close"></a>
		<div id="fancybox-title"></div>
		<a href="javascript:;" id="fancybox-left"><span class="fancy-ico" id="fancybox-left-ico"></span></a>
		<a href="javascript:;" id="fancybox-right"><span class="fancy-ico" id="fancybox-right-ico"></span></a>
	</div>


									<div class="productDetailCnt">
										<div class="pDetailList">
											<div class="listItem row_1">
												<div class="media">
													<span class="fl"><em class="detailIcon">&nbsp;</em></span>
													<div class="media-body">
														<h3>安不安全</h3>
														<p>本产品是中建投信托产品，上市公司宋都股份为该项目项下宋都集团的债务清偿提供连带责任保证责任，宋都股份为A股上市公司，浙江本地较大房地产企业，综合实力较强；</p>
														<p>标的项目为杭州市区内刚需楼盘，销售情况较好；还款来源充足。</p>
														<p>抵押物位于杭州桐庐大奇山郡未售现房，品质较高，抵押率不超过50%，抵押资产真实可靠。</p>
													</div>
												</div>
											</div>
											<div class="listItem row_2">
												<div class="media">
													<span class="fr"><em class="detailIcon">&nbsp;</em></span>
													<div class="media-body">
														<h3>钱去哪了</h3>
														<p>本产品由债权出让人购得中建投信托-安泉19号集合资金信托计划，用于宋都集团下属子公司香悦郡置业负责开发的杭州宋都香悦郡项目的开发建设。</p>
													</div>
												</div>
											</div>
											<div class="listItem row_3">
												<div class="media">
													<span class="fl"><em class="detailIcon">&nbsp;</em></span>
													<div class="media-body">
														<h3>购买准备</h3>
														<p>1. 首次购买需开通理财账户，理财账户可直接进行充值。</p>
														<p>2. 了解申购所用银行卡支持情况，大额支付需要网银，支持银行数量和支付限额高；快捷支付方便迅速，但支持银行数量有限。</p>
														<p>3. &nbsp;产品限量抢购，提前充值可以大大提升抢购成功率。</p>
													</div>
												</div>
											</div>
											<div class="listItem row_4">
												<div class="media">
													<span class="fr"><em class="detailIcon">&nbsp;</em></span>
													<div class="media-body">
														<h3>怎样赎回</h3>
														<p>产品到期后本金和收益将自动回款至您的理财账户，产品到期前暂不支持提前赎回。</p>
													</div>
												</div>
											</div>
											<div class="tipRow f12 g9">由于理财资金管理运用过程中，可能会面临多种风险因素，在您选择购买本理财产品前，请充分认识风险，谨慎投资</div>
										</div>
									</div>
								</div>
							</div>

							<div class="box" style="display: none;">
								<p style="text-align: center">
									<strong><span style="font-size: 21px; font-family: &amp; #39;微软雅黑&amp;#39;,&amp;#39;sans-serif&amp;#39;">项目亮点</span></strong>
								</p>
								<p class="MsoListParagraph" style="margin-left: 48px">
									<strong><span style="font-family: &amp; #39;微软雅黑&amp;#39;,&amp;#39;sans-serif&amp;#39;"></span></strong>
								</p>
								<p>
									1、<strong>宋都股份为A股上市公司，浙江本地较大房地产企业，综合实力较强：</strong>
								</p>
								<p>截至2014年末，宋都股份总资产136.85亿元，总负债98.01亿元，资产负债率71.62%。宋都股份2014年全年主营业务收入约23.23亿元，净利润为0.55亿元，主要来源于房地产销售收入，销售净利率2.35%。2015年3月末，宋都股份主营业务收入约7.37亿元，净利润0.61亿元。根据预测，其未售存货按照目前的售价估算未来的可售金额可达到140亿元左右，结合其未来工程款投入压力较小的因素，宋都股份整体未来2年内的现金流对本信托计划有较好的保证能力。</p>
								<p>
									<br>
								</p>
								<p>
									2、<strong>标的项目为杭州市区内刚需楼盘，销售情况较好：</strong>
								</p>
								<p>目前项目工程进度至地上主体工程二分之一左右程度，截至2015年5月末，已推盘去化率（按套数）大约52%。由于属于纯刚需楼盘，项目目前销售情况良好，信托计划第一还款来源较为充足。</p>
								<p>
									<br>
								</p>
								<p>
									3、<strong>抵押物位于杭州桐庐大奇山郡未售现房，品质较高，抵押率不超过50%：</strong>
								</p>
								<p>大奇山郡置业拥有的位于杭州桐庐的大奇山郡项目已竣工未销售的现房资产或其他受托人认可的资产，抵押率不超过50%。</p>
								<p class="MsoListParagraph" style="margin-left: 48px">
									<span style="font-family: &amp; #39;微软雅黑&amp;#39;,&amp;#39;sans-serif&amp;#39;"></span><br>
								</p>
								<p style="text-align: center">
									<strong><span style="font-size: 21px; font-family: &amp; #39;微软雅黑&amp;#39;,&amp;#39;sans-serif&amp;#39;">增信措施</span></strong>
								</p>
								<p>
									<strong>连带责任保证担保</strong>
								</p>
								<p>上市公司宋都股份为本项目项下宋都集团的债务清偿提供连带责任保证责任。</p>
								<p>
									<br>
								</p>
								<p>
									<strong>抵押担保</strong>
								</p>
								<p>大奇山郡置业以其持有的位于杭州桐庐的大奇山郡项目存量房产提供抵押担保或其他受托人认可的资产提供担保，抵押率不超过50%。</p>
								<p>
									<br>
								</p>
								<p>
									<strong>资金归集</strong>
								</p>
								<p>1、销售资金归集</p>
								<p>当目标项目可售货值&lt;全部信托贷款本金余额*1.5时，如宋都集团未提前一次性偿还全部信托贷款本金及利息，则自目标项目可售货值〈全部信托贷款本金余额*1.5之日起，目标项目销售回款（销售回款以所有按揭银行发放的按揭贷款流水金额以及宋都集团书面提供的首付款金额统计为准，下同）每满5000万元时，宋都集团应向归集账户归集资金人民币3500万元。</p>
								<p>2、到期前归集</p>
								<p>各期贷款到期日前20日，归集该期贷款本金余额的5%；各期贷款到期日前10日，归集至该期贷款本金余额的20%；各期贷款到期日，归集至该期贷款本金余额的100%。</p>
								<p>
									<br>
								</p>
								<p>
									<strong>资金监管</strong>
								</p>
								<p>受托人委托商业银行作为本信托计划监管银行，对信托资金使用进行专项监管。</p>
								<p>
									<br>
								</p>
							</div>
							<div class="box" style="display: none;">
								<p>
									<strong>资金保障</strong>
								</p>
								<p>1.交易过程中盈+平台不触碰资金，资金在银行的监管下在银行账户间流动。</p>
								<p>2.交易资金由招商银行全面监管。</p>
								<p>3.资金流向清晰，资金安全有保障。</p>
								<p>
									<br>
								</p>
								<p>
									<strong>本息保障</strong>
								</p>
								<p>1.资金最终投向中建投信托产品，基础资产风险几乎为零，安全有保障。</p>
								<p>2.杭州吉威投资承担对该笔债权的回购义务，到期无条件偿付投资人本息。</p>
								<p>3.盈+平台对资金真实投向中建投信托产品的过程提供保障。如果因资金没有流向中建投信托产品而发生损失，盈+平台100%全额赔付本息。</p>
								<p>
									<br>
								</p>
								<p>
									<strong>盈+平台风控综述</strong>
								</p>
								<p>盈+平台通过与知名企业合作，利用互联网金融的高周转和灵活性，择时提供既能给盈主（平台客户）带来不错的收益，又能满足低资金成本需求的理财产品。</p>
							</div>
						</div>
					</div>


					<div class="layui-tab-item" style="width: 100%; height: 100%">
						<div style="background: url(/YJLC_E/font/img/xmxq.png); width: 100%; height: 1000px"></div>
					</div>


					<div class="layui-tab-item" style="width: 100%; height: 100%">
						<div style="background: url(/YJLC_E/font/img/aqbz.png); width: 100%; height: 450px"></div>
					</div>

				</div>
			</div>
		</div>

		<br>
		<br>
		<br>
		<br>
		<div class="picList">
			认证文件展示
			<ul>
				<li><a href="/YJLC_E/font/productFiles/1442455557145.png"><img src="/YJLC_E/font/productFiles/1442455557145.png"></a></li>
				<li><a href="/YJLC_E/font/productFiles/1442455557158.png"><img src="/YJLC_E/font/productFiles/1442455557158.png"></a></li>
				<li><a href="/YJLC_E/font/productFiles/1442455557162.png"><img src="/YJLC_E/font/productFiles/1442455557162.png"></a></li>
				<li><a href="/YJLC_E/font/productFiles/1442455557165.png"><img src="/YJLC_E/font/productFiles/1442455557165.png"></a></li>
			</ul>
			<!-- <div style="clear:both;"></div> -->
		</div>

	</div>





	<div id="fancybox-tmp"></div>
	<div id="fancybox-loading">
		<div></div>
	</div>
	<div id="fancybox-overlay"></div>
	<div id="fancybox-wrap">
		<div id="fancybox-outer">
			<div class="fancybox-bg" id="fancybox-bg-n"></div>
			<div class="fancybox-bg" id="fancybox-bg-ne"></div>
			<div class="fancybox-bg" id="fancybox-bg-e"></div>
			<div class="fancybox-bg" id="fancybox-bg-se"></div>
			<div class="fancybox-bg" id="fancybox-bg-s"></div>
			<div class="fancybox-bg" id="fancybox-bg-sw"></div>
			<div class="fancybox-bg" id="fancybox-bg-w"></div>
			<div class="fancybox-bg" id="fancybox-bg-nw"></div>
			<div id="fancybox-content"></div>
			<a id="fancybox-close"></a>
			<div id="fancybox-title"></div>
			<a href="javascript:;" id="fancybox-left"><span class="fancy-ico" id="fancybox-left-ico"></span></a> <a href="javascript:;" id="fancybox-right"><span
				class="fancy-ico" id="fancybox-right-ico"></span></a>
		</div>
	</div>
	<div></div>

	<div style="margin-top: 15px;">

		<!-- 示例-970 -->
		<ins class="adsbygoogle" style="display: inline-block; width: 970px; height: 90px" data-ad-client="ca-pub-6111334333458862"
			data-ad-slot="3820120620"></ins>

	</div>

	<center>
		<br>
		<br>
		<div style="height: 150px; width: 975px; background: url(/YJLC_E/font/img/fk.png);"></div>
		<br> <br>
	</center>


	<div style="margin-top: 15px;">

		<!-- 示例-970 -->
		<ins class="adsbygoogle" style="display: inline-block; width: 970px; height: 90px" data-ad-client="ca-pub-6111334333458862"
			data-ad-slot="3820120620"></ins>

	</div>

	<div style="width: 100%; height: 659px; background: url(/YJLC_E/font/img/fontDown01.png);"></div>
	<script>
layui.use('element', function(){
  var $ = layui.jquery
  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
  
});
</script>

</body>
</html>