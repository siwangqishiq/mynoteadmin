CREATE TABLE version(
    id LONG PRIMARY KEY NOT NULL,--主键
    versionCode INT NOT NULL,--版本号
	versionName VARCHAR(100),--版本名称
    versionType INT NOT NULL,--版本类型 1.ios 2.android
    url VARCHAR(1000),--包下载地址 (ios不用)
    descrption NVARCHAR(500),--描述
    extra NVARCHAR(500)--备注
);