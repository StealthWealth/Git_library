package com.web.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016081500253277";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCNbUzCRXF72+hCgCpJeq7UoMzTLuuQ2MZl2fu038moJ0WcjrOF1lkIwItC1jSwUfP+PlPmBuZ5myqajkNZ0a7kfKDfXxNAO4GEs745gp5DGG+7taU8B8YNS86pWp1lXZ0uV19dsrXez+Oci4AkhzftwauUGrLNgrWP1Q0AYhr+I62Fys0lcZ1QilNGMZIGIqG1nllcMTM0zAfu/j1wUlrchwZ2vvpDcmxb8fYTZZs3ov0s5jef5+2RBLSgcacf0r5zT2Kyp19LpBUkmwDoMQ9z5De4WDCWow4OoGSCAjw+xZHLvRnLGBTLA6ctgcbHn4+nkyPLpXVTPiHtcf/SH7eFAgMBAAECggEATmYqyP8J++laBZNa3cTeqgxBv0ghWfhxcwC14fy0ozyyACmzJxw92vYxvOlV5/BmW6hdhgSJOxxjL65xc5cjZpIX8/uWhmL2V4P0jZj09qjTN7FoWbDNf41okMUkv453lbrlqOFqpIuF18AVVyqGPIzB+qYaPIaa85LdVDsOT5bPnKq+XGdoBTicAE1+A/o8JVA3/J96TsktNTdoy2L0K8X3W/LrKkyS2lhadU/D/jP1H5mnDrwjRP9r7rGRwjpnqRf7MFV0O9GwXWYOs5tk+xZ/xar3I6MPxWpHGutQrzCXAtevohO2KVXcFRT2OURao0yQi3k91B3UsTmwibghQQKBgQDR9fv47V0mxafO7z0fARqLqyA/gz1dMe93BAgKetGFVC2SMFAzrCejCCbxGBceYLPq1GKeGLoOBV3VUEO/LOYY4zfxAYZaCSrFq4EUgalK1+TwZJZFfA/RYFlzeHVo1qeQYSa9F5dylZkb63FrWbIRL+QJE7MUtkQDeAiJzXx52QKBgQCscDV2GQGlV1BgrYgvMZBWMhdo8hzBbvkP74JpHOi+xGm5QtnjmZdU6ZC5mbJXeqrIFB12fXJStK+W38p2X+P+kFyjkKA8AIwUwPkHkwHdrW8WMpsAdvCCSG0of8JwQjZJUrHasdDgsJbUEfT+TQ8FouKAtaawSSA4iZOO/sGTjQKBgQDQVVl5jeWBZFz3O3IVgp3Zeqrb+ph4EeV/3dMwut+NgZJaXXAnZapK3frt/a5q6R99YtKb9wMeiHqsACHI339NsKBAlve9/Ryg2WWSeHoIFqNHWTe2qLx1UDpSFnPB3ESWQaATvwX6n7A2APAgyfajkTafPxnR8m0YWBF40xmxOQKBgHhaFKYpi+GHkFz5oPw3XqMacQZZPUKwnnrF0sJkX/mNgrC//O2CrIGiRtWTdUrjHcFpcKrboWgiHg9ygI+gG7P3tAChF4TpaNuvV+A2dW3v94GJrm9jlDeKL0295cqOG++PHP0jcELyXUMEiXbX960aY3Yr0nxlfWyYcPmzyw2dAoGAXMmnxF4LCaws8ILKhdIuAutLacspQHBBV1S0oqSX0ryLyIyLNve7JcMreJEb0yUou4zuQNFwHn4KdOdk+2Mc7QY3CfWZTuDUWfpClZ2y/9l8WeGX1PmhsPQ9F2cgR3qAzOsmhdTn+AsWl1hfMgyLK1nkjxKa9CZSD4RbHvw5vSo=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArab3ubHCQohtmNC2wj+0YUh21VNfVmfBIZBwDyf+3UgBjYp0Z0+HN3L8nMkMEYGusyzsjBxohdgMLEgF5UCrPrrd7MiaG2cKLlB9DFZ7+l9j6VZGLX93N1GPzME6rvXjBDzjLFZBKjU+Pm6DVXHdfy8Gi2Ch7xovCgz2u+io+sFECV5JmpjcL0RoWDDUovRw+47XAKeU3sC8jsi3wDiBd6gOY3johlfZCWrUetEnTNX/VqV1ocJXfwhwRB0K9xWPyjQiEfXqEweiWJ62VpNQbjmMLlZWW1muJbiQxtqzf7NASgKg+z499Z/xHz+TDctU2QIrXfjx+OPdNiruQEe0CwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String notify_url = "http://localhost:8080/YJLC_E/alipay/notifu";
    public static String notify_url = "http://localhost:8080/YJLC_E/alipay/notifu";
    
    
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String return_url = "http://localhost:8080/YJLC_E/alipay/return";
    public static String return_url = "http://localhost:8080/YJLC_E/alipay/tongbu";
    

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

