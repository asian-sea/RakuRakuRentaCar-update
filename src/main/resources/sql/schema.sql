drop table if exists users;
drop table if exists cars;
drop table if exists grades;
drop table if exists shops;
drop table if exists options;
drop table if exists reservation_cars;
drop table if exists reservation_options;

create table users (
  id serial primary key
  , name text not null
  , email text not null unique
  , password text not null
  , address text not null
  , telephone text not null
) ;

create table cars (
  id integer primary key
  , name text not null
  , grade_id integer
  , shop_id integer
  , imagePath text not null
  , deleted boolean default false not null
) ;

create table grades (
  id integer primary key
  , name text not null
  , price integer
  , imagePath text not null
) ;

create table shops (
  id integer primary key
  , name text not null
  , address text
) ;

create table options (
  id integer primary key
  , name text not null
  , price integer not null
) ;

create table reservation_cars (
    id serial primary key
    , status integer not null
    , car_id integer not null
    , start_date timestamp not null
    , end_date timestamp not null
    , total_price integer not null
    , user_id integer not null
    , settlement_id integer not null
);

create table reservation_options (
	id serial primary key
	, option_id integer not null
	, reservation_car_id integer not null
);

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
insert into cars values(10, 'シャトル', '1', '1', 'shuttle.jpg');
insert into cars values(11, 'ソリオ', '1', '1', 'solio.jpg');
insert into cars values(12, 'ノート', '1', '1', 'note.jpg');
insert into cars values(13, 'パッソ', '1', '2', 'passo.jpg');
insert into cars values(14, 'フィット', '1', '2','fit.jpg');
insert into cars values(15, 'タント', '1', '3', 'tanto.jpg');
insert into cars values(16, 'スカイライン', '2', '1', 'skyline.jpg');
insert into cars values(17, 'シビック', '2', '1', 'civic.jpg');
insert into cars values(18, 'フーガ', '2', '1', 'fuga.jpg');
insert into cars values(19, 'カローラ', '2', '2', 'carolla.jpg');
insert into cars values(20, 'インプレッサ', '2', '2', 'impreza.jpg');
insert into cars values(21, 'プリウス', '2', '3', 'prius.jpg');
insert into cars values(22, 'レガシィ', '2', '3', 'legacy.jpg');
insert into cars values(23, 'NSX', '3', '1', 'nsx.jpg');
insert into cars values(24, 'LC', '3', '1', 'lc.jpg');
insert into cars values(25, 'GT-R', '3', '2', 'gt-r.jpg');
insert into cars values(26, 'ポルシェ', '3', '2', 'porsche.jpg');
insert into cars values(27, 'ロードスター', '3', '3', 'roadster.jpg');
insert into cars values(28, 'NSX', '3', '3', 'nsx.jpg');
insert into cars values(29, 'ヘネシーヴェノム', '4', '1', 'hennessey_venom_gt.jpg');
insert into cars values(30, 'ベンツSクラス', '4', '1', 'bentz.jpg');
insert into cars values(31, 'キャデラック', '4', '2', 'cadillac.jpg');
insert into cars values(32, 'ランボルギーニ', '4', '3', 'lamborghini.jpg');

insert into grades values(0, '---', 0, '---');
insert into grades values(1, 'コンパクトカー', '1000', 'vitz.jpg');
insert into grades values(2, 'セダン', '1200', 'atenza.jpg');
insert into grades values(3, 'スポーツカー', '1500',  'roadster.jpg');
insert into grades values(4, '高級輸入車', '2000',  'bentz.jpg');

insert into shops values(0, '---', '---');
insert into shops values(1, '新宿店', '東京都新宿区新宿4丁目');
insert into shops values(2, '渋谷店', '東京都渋谷区渋谷');
insert into shops values(3, '池袋店', '東京都豊島区西池袋');

insert into options values(1, '喫煙', 0);
insert into options values(2, 'ETC', 300);
insert into options values(3, 'チャイルドシート', 300);