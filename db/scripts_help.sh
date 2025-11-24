# Build with a Tag  to a image
docker build -t auth_nerdery .

# Run the image with a volume to persist the DB data
docker run -d -p 5432:5432 -v pgdata:/var/lib --name auth_nerdery_container auth_nerdery
