import os
import re
from string_xml_manipulation import StringsXMLManipulator
from enum import Enum

class Language(Enum):
    CN = ("cn", "translation/xmls/cn-strings.xml")
    VI = ("vi", "translation/xmls/vi-strings.xml")
    EN = ("en", "translation/xmls/en-strings.xml")

    def __init__(self, code, path):
        self.code = code
        self.path = path

SRC_PATH = "app/src/main/java"
TARGET_LANGUAGE = Language.EN

def get_all_java_files_path():
    java_files = []
    for root, dirs, files in os.walk(SRC_PATH):
        for file in files:
            if file.endswith(".java"):
                full_path = os.path.join(root, file)
                java_files.append(full_path)
    return java_files


def get_java_content_lines(file_path):
    with open(file_path, 'r') as file:
        return file.read().split("\n")

def contains_chinese_characters(line):
    return bool(re.search(r'[\u4e00-\u9fff]', line))

def extract_chinese_strings(line):
        return re.findall(r'"([^"]*[\u4e00-\u9fff][^"]*)"', line)

def get_java_content(file_path):
    with open(file_path, 'r') as file:
        return file.read()
#------------------------- Main -------------------------

def extract_all_strings():
    manipulator = StringsXMLManipulator("strings.xml")
    manipulator.create_new_strings_xml()
    for java_file in get_all_java_files_path():
        lines = get_java_content_lines(java_file)
        chinese_lines = [line for line in lines if contains_chinese_characters(line)]
        for line in chinese_lines:
            chinese_strings = extract_chinese_strings(line)
            for string in chinese_strings:
                print(string)
                manipulator.add_string(string, string, override_if_conflict=True)
        manipulator.reformat_strings_xml()


def apply_all_strings_to_code():
    manipulator = StringsXMLManipulator(TARGET_LANGUAGE.path)
    for java_file in get_all_java_files_path():
        translated_lines = []
        lines = get_java_content_lines(java_file)
        # lines = [line for line in lines if contains_chinese_characters(line)]
        line_count = 0
        for line in lines:
            if contains_chinese_characters(line):
                chinese_strings = extract_chinese_strings(line)
                for chinese_string in chinese_strings:
                    print(chinese_string)
                    line = line.replace(chinese_string, manipulator.get_string(chinese_string))
                    # content = content.replace(chinese_string, manipulator.get_string(chinese_string))
                translated_lines.append(line)
            else:
                translated_lines.append(line)
            line_count += 1
        with open(java_file, 'w') as file:
            file.write("\n".join(translated_lines))
            # break

# print(get_java_content("app/src/main/java/dm/Npc.java"))


# string = StringsXMLManipulator(TARGET_LANGUAGE.path).get_string("您已发送")
# print(string)
apply_all_strings_to_code()