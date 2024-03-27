## keterangan
() = perintah
[] = perintah lanjutan
[?] = hint perintah lanjutan
[AS] = Autonomous





## telnet :
(Enable secret) [password](untuk konfigurasi)
(Enable password) [password]()
([show][running][config])
enkripsi [service][password-enkripsi]
mengatur line [line][console][0]
mengatur (Line vty) [0 4]
password untuk telnet [password][yourpassword]


## Statis Routing(step by step)
## sett ip route
(Ip address) fa/gi 0/0 :
(Int) [fa/gi] 0/0
(ip add) [sesuaikan][subnet]
## sett ip switch
(Ip add) [sesuaikan]
(Ip address) fa/gi 0/1 :
(Int) [fa/gi] 0/1,1/0,...
(ip add) [sesuaikan][subnet]
## sett dhcp (Dynamic Host Configuration Protocol)
didalam int fa/gi 0/1,1/0,...
(ip dhcp pool [nama])
(net)[ipaddress]
(default[tab])[ipaddress]
(ip dhcp ex[tab][ipaddress])

## Static Routing(real)
[KeadaanKonfigurasi](ip route[tab])[ipTujuanXpc1,pc2,pc3[mask]][ipRouteSeberangnyaXgi0/0]
`BOLAK BALIK ANTAR ROUTE`

## Routing Dinamis

## rip v2 (Protokol Informasi Perutean)
[LangkahPembagianIP]
[LangkahDHCP]
[masukKonfigurasi](route)[?]
[?](v2)
[?](netSesuaiRouter)
[?](networkSwitch)
`Jikalau menambahkan router baru harus konfigurasi juga di router tersebut`
`BOLAK BALIK ANTAR ROUTER`

## ospf (Open Shortest Path First)
[LangkahPembagianIP]
[LangkahDHCP]
[masukKonfigurasi](route)[?][1-65335]
[?](netSesuaiRouter)[wildCard][area 0]
[?](netSesuaiSwitch)[wildCard][area 0]
`Lakukan Bolak Balik`

## bgp (Border Gateway Protocol)
[LangkahPembagianIP]
[LangkahDHCP]
[masukKonfiguras](route)[?][1-65335]
[neigh](ipSesuaiRouterTetangga)[remote-as](bgpTetangga)
[?](netSesuaiRouter)[mask][subnet]
[?](netSesuaiSwitch)[mask][subnet]

