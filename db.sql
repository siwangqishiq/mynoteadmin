CREATE TABLE version(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    versionCode INT,
    versionName VARCHAR(100),
    url VARCHAR(1000),
    descrption NVARCHAR(500),
    extra NVARCHAR(500),
    status INT DEFAULT 0,
    type INT,
    updateTime LONG,
    createTime LONG
);