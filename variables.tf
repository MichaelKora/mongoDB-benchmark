variable "server_count" {
  type = number
  default = 3
}

variable "instance_tz" {
  type = list(string)
  default = ["europe-west3-a", "australia-southeast1-a", "asia-southeast1-c", "northamerica-northeast1-c", "us-east4-a", "us-central1-b"]
}
