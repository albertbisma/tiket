# cimb_niaga

For Access API pegawai you can clone from this repository than run on your favorite IDE.

After the project is running well, you can access http://localhost:8080/swagger-ui.html
or
you can access with curl 

Pegawai Get
=================================================================================
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/pegawai?userId=1'


Pegawai Insert 
==================================================================================
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "alamat": "Masukkan alamat disini", \ 
   "nama": "Masukkan nama disini" \ 
 }' 'http://localhost:8080/pegawai'
 
 Database File
 ==================================================================================
 For **Database** you can go to folder "pegawai\src\main\resources"
 With file name **dump-cimb_niaga-202104290057.sql** then import to your DBMS
