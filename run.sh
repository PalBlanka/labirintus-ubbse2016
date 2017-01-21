# get display passcode to pass to container
XSOCK=/tmp/.X11-unix
DISPLAY_HEX="$(xauth list|grep `uname -n`|sed -E 's/(.*) ([^ ]*)/\2/')"

# launch Docker container with hex code forwarded
sudo docker run -ti --rm -e DISPLAY=unix$DISPLAY -e DISPLAY_HEX=$DISPLAY_HEX -v $XSOCK:$XSOCK helloworld
