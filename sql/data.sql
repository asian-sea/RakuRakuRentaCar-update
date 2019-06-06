insert into users (name, email, password, address, telephone)
values ('山田太郎', 'test@test.co.jp', 'password', '東京都新宿区新宿4町目', '0120-123-123');

insert into cars values(1, 'デミオ', '1', '1', 'demio.jpg');
insert into cars values(2, 'ヴィッツ', '1', '2', 'vitz.jpg');
insert into cars values(3, 'マーチ', '1', '3', 'march.jpg');
insert into cars values(4, 'レガシィ', '2', '1', 'legacy.jpg');
insert into cars values(5, 'アテンザ', '2', '2', 'atenza.jpg');
insert into cars values(6, 'フーガ', '2', '3', 'fuga.jpg');
insert into cars values(7, 'ロードスター', '3', '1', 'roadster.jpg');
insert into cars values(8, 'BRZ', '3', '2', 'brz.jpg');
insert into cars values(9, '86', '3', '3', '86.jpg');

insert into grades values(1, 'コンパクトカー', '1000');
insert into grades values(2, 'セダン', '3000');
insert into grades values(3, 'スポーツカー', '4000');

insert into shops values(1, '新宿店', '東京都新宿区新宿4丁目');
insert into shops values(2, '渋谷店', '東京都渋谷区渋谷');
insert into shops values(3, '池袋店', '東京都豊島区西池袋');

insert into options values(1, '喫煙', 0);
insert into options values(2, 'ETC', 300);
insert into options values(3, 'チャイルドシート', 300);