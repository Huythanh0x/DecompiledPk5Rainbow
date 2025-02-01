import os
import xml.etree.ElementTree as ET

class StringsXMLManipulator:
    def __init__(self, file_path):
        self.file_path = file_path

    def create_new_strings_xml(self):
        root = ET.Element("resources")
        tree = ET.ElementTree(root)
        tree.write(self.file_path, encoding='utf-8', xml_declaration=True)
        print(f"Created new strings.xml file at {self.file_path}")

    def add_string(self, name, value, override_if_conflict=False):
        if not os.path.exists(self.file_path):
            raise FileNotFoundError(f"{self.file_path} does not exist. Please create it first.")

        tree = ET.parse(self.file_path)
        root = tree.getroot()

        existing_element = root.find(f"./string[@name='{name}']")
        if existing_element is not None:
            if override_if_conflict:
                existing_element.text = value
                print(f"Overridden existing string with name '{name}'")
            else:
                print(f"String with name '{name}' already exists. Use override_if_conflict=True to override.")
                return
        else:
            new_string = ET.Element("string", name=name)
            new_string.text = value
            root.append(new_string)
            print(f"Added new string with name '{name}'")

        tree.write(self.file_path, encoding='utf-8', xml_declaration=True)

    def reformat_strings_xml(self):
        if not os.path.exists(self.file_path):
            raise FileNotFoundError(f"{self.file_path} does not exist. Please create it first.")
        with open(self.file_path, 'r') as file:
            content = file.read()

        formatted_content = content.replace("</string><string", "</string>\n<string")
        # formatted_content = content.replace("<resources><string", "<resources>\n<string")
        # formatted_content = content.replace("</string></resources>", "</string>\n</resources>")

        with open(self.file_path, 'w') as file:
            file.write(formatted_content)

        print(f"Reformatted strings.xml file at {self.file_path}")

    def remove_string(self, name):
        if not os.path.exists(self.file_path):
            raise FileNotFoundError(f"{self.file_path} does not exist. Please create it first.")

        tree = ET.parse(self.file_path)
        root = tree.getroot()

        element_to_remove = root.find(f"./string[@name='{name}']")
        if element_to_remove is not None:
            root.remove(element_to_remove)
            tree.write(self.file_path, encoding='utf-8', xml_declaration=True)
            print(f"Removed string with name '{name}'")
        else:
            print(f"No string found with name '{name}'")

    def get_string(self, name):
        if not os.path.exists(self.file_path):
            raise FileNotFoundError(f"{self.file_path} does not exist. Please create it first.")

        tree = ET.parse(self.file_path)
        root = tree.getroot()

        element = root.find(f"./string[@name='{name}']")
        if element is not None:
            return element.text
        else:
            print(f"No string found with name '{name}'")
            return None


# Example usage
if __name__ == "__main__":
    print(f"Current working directory: {os.getcwd()}")
    manipulator = StringsXMLManipulator("strings.xml")
    manipulator.create_new_strings_xml()
    manipulator.add_string("welcome_message", "Welcome to our application!", override_if_conflict=True)
    print(manipulator.get_string("welcome_message"))
    # manipulator.remove_string("welcome_message")