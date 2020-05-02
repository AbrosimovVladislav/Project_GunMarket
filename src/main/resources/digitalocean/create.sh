sudo apt update
sudo apt remove nodejs

# docker
sudo apt -y install docker.io
sudo curl -L "https://github.com/docker/compose/releases/download/1.25.5/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

# front
git clone https://github.com/AbrosimovVladislav/JackNorthon
cd JackNorthon
git checkout feature/filter
curl -sL https://deb.nodesource.com/setup_12.x | sudo -E bash -
sudo apt -y install nodejs
sudo npm install -g @angular/cli@9.1.1
sudo npm install
sudo ng build --prod
cd ..

# postgresql
echo "deb http://apt.postgresql.org/pub/repos/apt/ $(lsb_release -cs)-pgdg main" | sudo tee /etc/apt/sources.list.d/pgdg.list
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo apt update
sudo apt -y install postgresql-12 postgresql-client-12
sudo su - postgres
psql -c "ALTER USER postgres WITH PASSWORD 'root'"
psql -c "CREATE DATABASE gunmarket"
exit

# back
sudo apt install default-jdk
sudo apt install maven
cd Project_GunMarket | git checkout develop | mvn clean package
