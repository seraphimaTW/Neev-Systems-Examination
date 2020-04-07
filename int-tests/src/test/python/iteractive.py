#!/usr/bin/env python

import unittest
import pexpect


class TestInteractive(unittest.TestCase):
    cli_cmd = "java -jar core/build/libs/core-main.jar"

    def test_interactive_mode_username_and_password_sent_to_server(self):
        child = pexpect.spawn(TestInteractive.cli_cmd, timeout=10000)
        child.expect('Welcome to the ExaminationCLI!')
        child.expect('Please make you selection: NAME or CODE. If you would like to exit, enter QUIT')
        child.sendline('NAME')
        child.expect('Please enter country name')
        child.sendline('abcd')
        child.expect('We were not able to found any data for your input, please try again')
        child.expect('Type YES to continue')
        child.sendline('exit')
        child.expect(pexpect.EOF)

