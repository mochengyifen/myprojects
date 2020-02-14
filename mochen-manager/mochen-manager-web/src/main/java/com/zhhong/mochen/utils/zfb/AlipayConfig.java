package com.zhhong.mochen.utils.zfb;

public class AlipayConfig {
    // 商户appid
    public static String APPID = "2019080766116522";
    //私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDbi7rCA4GUGH5izj21aLLbAHpqiJe0NXauXvh+CN3BADKfcJieoiRJ8xQQAflP5cwoV3XAqy1Go2IqOQORXxBNREXR+VCj5NGUa39Nccnwd3qNQ76ltNGaTWi83QvASuzahBqt6dRQcILmcTInUTrWJOGyTScQlVAHbBq7Xr8oUPA07mMzt2g/cJWc7gGFX6pyOP+RtG5qnYkaD8C9SfVp0PPSd/rB+16ffGPOTFfD+mrhAdgCeDIUImtPZ5dXz1IMhF39PVkND4URpyWc3/uWBIjYgjjXvCjNMtmR3BcH4SbOJLvmBG/F28BZDk4JiOn4u3qkDtqtE5sw7ByDcgZPAgMBAAECggEBAMACW6q08E36ggaeA6A12j7pEyc7IRqNq6djDgcEcBUMvDlvezs56Wz3d/NsFoSHIN+jZivEScu+turghDtOne5FqJ60Yo+EXrtkrKipvQhfJkKIHiPEmZBO5SxQUqexn6aY5NB3caWMUR+Dnm5+f2usQ+vxyBmbzKtBI7v9aEezqmd+Zm1BN83C+UPp9F6htYebantvXjGMMwAByludxSTs2LQD6bs+BVd9iG5V2aZLzhU4/QSZT/H/CIW/IQZjlq5kCr1kHkjCe9XRPPYp5vb8F2nUP1px7+vKHHxezcSh1I7J4guujtq4AT+lSwxEpC+629MwWhbf8K3C8UVJaNECgYEA/MxpFUwybuwVRnyovM1v8wwftCtchDheRiQJ+0saT+Vm2B5BXc1DchzKI1xzHT+wGsohBNPUOYUSZayVdlQH5hCLQmL1mo21skwQMtrWXjYiQCHg4g3snLgjdeEWwS7wf9Y/um7/dXwAjnnTC+xzxdSLXf1G+5aAXBFeT3BUs5kCgYEA3lOC/twZt8JVgvfKbHHE4g0qEL9xrt6fBLwAKOyRri3OiWByq1dq9f6vDd0LiuJhtML7M80LQhncNIMCHw+F2bbv9ceDEpdXRBHCVM+u2AA4+ZCcADje4zopifTVNVEXmAQ9/YXmFM8FsVFHPjGu1iXKig9Xs4kRA11DYuzqOicCgYEA9ltSEOJHx9ckSKPVYOEntwjaoJ8dMvEn1lzqqU0gYDokBns9omcV0lACIYHH4Poe6YyPrv+sMz3elt0gbscnR2pZ/CEqTirJpe8AXj7rZ7aDnFInsMR3EKdWT1tC7JKM51folQv0wg5NEIviQx10GZevFbJtCWM6xf5bFTlYIgkCgYA2kP6kuLajMFI2i8Sl6yJsbNi3NZWcWs1ipxXO9Ykn29xGQWLDhPgemjyyxV7w3nEmoXhwFVI/DgPK66CYqQGsFsc8ZpRX+scTUNyGXlbGcv+I2SJAt7SUxpCtaGbv6BBHYjsovzViRBFcnNtEe4My0iGs0ukuimSfk8NXQ1iVnwKBgQC7A+BpaufWgjAJFp/7jzputRA7dNLBoQ2ipyoCXhxoJyu4d/wG9+eeFBcxUcdTeWMh4HtbrPu/kL9G0C1JXVF3OFg/svWWJ0D/CFF0MvT08Viq8UhEeKf1euXelU0dwvflGK72c9FHpXS3v+ZnpnkKCWC9THOQiDO9xqdW2J2c+Q==";

    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "https://www.fengwocm.com/honeyAdvertService/ZfbPay/zfbNotify.action";

    //页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "";

    // 请求网关地址
    public static String URL = "https://openapi.alipay.com/gateway.do";
    // 编码
    public static String CHARSET_UTF8 = "UTF-8";
    public static String CHARSET_GBK = "GBK";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyx/mTchLPDU67DCLOVcE2dDlS3USrNbcCa/bFoVbJU/CgzXxO/QAH2T5R8DRRZj7kcsnN9UIOc79hNo2JsPbhAL6RPJvBC6lIog6GzvJMVdSUiH08A7Sfn865CEXk78WrtRU/1dGKQj1YGwccvFnKwUfWC5HK0/rGc5z3mU81goNmbYsNqfJpzFrPdQoIp0UDsWsH+frRdXtAM7ZtYvqdCs2ZqQ/qaa0Yn5a9zVPAf5vUOGS1OwzAhNf7NXh1dVpbRDxmtmcebxCHPa4DnIYOn9GlVSgm+TDUA+xujpO5D5+PcljBxzfnikP88sYAMFsyZglWneQw8/63JdGA7e5/QIDAQAB";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";
}