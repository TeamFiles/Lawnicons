#!/usr/bin/env python3
import os
import sys
from telethon import TelegramClient
from telethon.sessions import StringSession
from telethon.tl.types import PeerUser, PeerChat, PeerChannel

api_id = os.environ['APIID']
api_hash = os.environ['APIHASH']
bot = os.environ['BOTTOKEN']
chat_id = int(os.environ['CHATID'])

FILE = sys.argv[1]
MSG = sys.argv[2]


client=TelegramClient('bot', api_id, api_hash)
client.start(bot_token=bot)

async def main():
    await client.send_file(PeerChannel(chat_id), FILE, caption=MSG, parse_mode='md')

with client:
    client.loop.run_until_complete(main())