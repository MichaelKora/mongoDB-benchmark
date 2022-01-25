#!/bin/bash
  

gcloud compute instances list > current_state.txt
cat current_state.txt
echo "[clients]" > /etc/ansible/hosts
grep "client-vm*" current_state.txt | awk '$6 == "RUNNING" {print $5 } " ansible_ssh_user=michaelkora"' >> /etc/ansible/hosts

echo "[servers]" >> /etc/ansible/hosts
grep "server-vm*" current_state.txt | awk '$6 == "RUNNING" {print $5 " ansible_ssh_user=michaelkora"}' >> /etc/ansible/hosts
echo "[master]" >> /etc/ansible/hosts
grep "server-vm-0" current_state.txt | awk '$6 == "RUNNING" {print $5 " ansible_ssh_user=michaelkora"}' >> /etc/ansible/hosts
