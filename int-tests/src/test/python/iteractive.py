#!/usr/bin/env python

import unittest
import pexpect

class TestInteractive(unittest.TestCase):
    cli_cmd = "java -jar core/build/libs/core-main.jar"

    def test_notexisting_country_name(self):
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

    def test_notexisting_2letter_country_code(self):
        child = pexpect.spawn(TestInteractive.cli_cmd, timeout=10000)
        child.expect('Welcome to the ExaminationCLI!')
        child.expect('Please make you selection: NAME or CODE. If you would like to exit, enter QUIT')
        child.sendline('CODE')
        child.expect('Please enter 2-letter or 3-letter country code')
        child.sendline('aa')
        child.expect('We were not able to found any data for your input, please try again')
        child.expect('Type YES to continue')
        child.sendline('exit')
        child.expect(pexpect.EOF)

    def test_notexisting_3letter_country_code(self):
        child = pexpect.spawn(TestInteractive.cli_cmd, timeout=10000)
        child.expect('Welcome to the ExaminationCLI!')
        child.expect('Please make you selection: NAME or CODE. If you would like to exit, enter QUIT')
        child.sendline('CODE')
        child.expect('Please enter 2-letter or 3-letter country code')
        child.sendline('abc')
        child.expect('We were not able to found any data for your input, please try again')
        child.expect('Type YES to continue')
        child.sendline('exit')
        child.expect(pexpect.EOF)

    def test_existing_country_name(self):
        child = pexpect.spawn(TestInteractive.cli_cmd, timeout=10000)
        child.expect('Welcome to the ExaminationCLI!')
        child.expect('Please make you selection: NAME or CODE. If you would like to exit, enter QUIT')
        child.sendline('NAME')
        child.expect('Please enter country name')
        child.sendline('Ukraine')
        child.expect('The Capital City name is Kiev')
        child.expect('Type YES to continue')
        child.sendline('exit')
        child.expect(pexpect.EOF)

    def test_existing_country_2letter_code(self):
        child = pexpect.spawn(TestInteractive.cli_cmd, timeout=10000)
        child.expect('Welcome to the ExaminationCLI!')
        child.expect('Please make you selection: NAME or CODE. If you would like to exit, enter QUIT')
        child.sendline('CODE')
        child.expect('Please enter country name')
        child.sendline('UA')
        child.expect('The Capital City name is Kiev')
        child.expect('Type YES to continue')
        child.sendline('exit')
        child.expect(pexpect.EOF)

    def test_existing_country_3letter_code(self):
        child = pexpect.spawn(TestInteractive.cli_cmd, timeout=10000)
        child.expect('Welcome to the ExaminationCLI!')
        child.expect('Please make you selection: NAME or CODE. If you would like to exit, enter QUIT')
        child.sendline('CODE')
        child.expect('Please enter country name')
        child.sendline('UKR')
        child.expect('The Capital City name is Kiev')
        child.expect('Type YES to continue')
        child.sendline('exit')
        child.expect(pexpect.EOF)

