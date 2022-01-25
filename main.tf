// Configure the Google Cloud provider
provider "google" {
 credentials = file("CREDENTIALS_FILE.json")
 project     = "tu-cloud-21"
// region      = "us-west1"
}

// Terraform plugin for creating random ids
resource "random_id" "instance_id" {
 byte_length = 8
}

// 3 server Compute Engine instances
resource "google_compute_instance" "default1" {
 count = var.server_count
 name         = "server-vm-${count.index}"

 machine_type = "e2-standard-2"
 zone         = var.instance_tz[ count.index ]

metadata = {
   ssh-keys = "michaelkora:${file("~/.ssh/id_rsa.pub")}"
 }
 boot_disk {
   initialize_params {
     image = "ubuntu-os-cloud/ubuntu-1804-lts"
   }
 }

// Make sure flask is installed on all new instances for later steps
 metadata_startup_script = "sudo apt-get update; sudo apt-get install -yq build-essential python-pip rsync; pip install flask"

 network_interface {
   network = "default"

   access_config {
     // Include this section to give the VM an external ip address
   }
 }
}


// 3 client  Compute Engine instances
//resource "google_compute_instance" "default" {
// count = 0 
// name         = "client-vm-${count.index}"
//
// machine_type = "e2-standard-2"
// zone         = var.instance_tz[count.index]
//
//metadata = {
//   ssh-keys = "michaelkora:${file("~/.ssh/id_rsa.pub")}"
// }
// boot_disk {
//   initialize_params {
//     image = "ubuntu-os-cloud/ubuntu-1804-lts"
//   }
// }
//
//// Make sure flask is installed on all new instances for later steps
// metadata_startup_script = "sudo apt-get update; sudo apt-get install -yq build-essential python-pip rsync; pip install flask"
//
// network_interface {
//   network = "default"
//
//   access_config {
//     // Include this section to give the VM an external ip address
//   }
// }
//}
//
//// A variable for extracting the external IP address of the instance
//output "ip" {
// value = google_compute_instance.default[0].network_interface.0.access_config.0.nat_ip
//}
