#!/bin/bash

terraform apply -var="server_count=1" -auto-approve

sh ./update_hosts_list.sh

for i in $(cat externalip.txt); do
    echo " keygen into $i"
    ssh-keygen -R $i

    echo "copy key to $i"
    ssh-copy-id -i -f  michaelkora@$i
done

ansible-playbook playbook.yml

#ssh-keygen -R 34.159.98.79
#ssh-copy-id -i -f  michaelkora@34.159.98.79



