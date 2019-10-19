
### Shows the PID and which service it was started by (e.g. mysgld).  

sudo netstat -nlpt | grep 3306

### Stop the service. Notice use of mysql and not mysqld.  

sudo service mysql stop