#!/bin/bash
  
gcloud compute instances list > current_state.txt
cat current_state.txt
echo "[clients]" > /etc/ansible/hosts
echo -n > externalip.txt
grep "client-vm*" current_state.txt | awk '$6 == "RUNNING" {print $5 } " ansible_ssh_user=michaelkora"' >> /etc/ansible/hosts
grep "client-vm*" current_state.txt | awk '$6 == "RUNNING" {print $5 }' >> externalip.txt 

echo "[servers]" >> /etc/ansible/hosts
grep "server-vm*" current_state.txt | awk '$6 == "RUNNING" {print $5 " ansible_ssh_user=michaelkora"}' >> externalip.txt >> /etc/ansible/hosts
grep "server-vm*" current_state.txt | awk '$6 == "RUNNING" {print $5 }' >> externalip.txt 

echo "[master]" >> /etc/ansible/hosts
grep "server-vm-0" current_state.txt | awk '$6 == "RUNNING" {print $5 " ansible_ssh_user=michaelkora"}' >> /etc/ansible/hosts
